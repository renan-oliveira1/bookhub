package com.bookhub.books.services;

import com.bookhub.books.dto.BookDto;
import com.bookhub.books.dto.BookMapper;
import com.bookhub.books.entities.Book;
import com.bookhub.books.exception.BooksException;
import com.bookhub.books.repositories.BooksRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class BooksService implements IBooksService{
    private BooksRepository booksRepository;

    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    @Override
    public BookDto save(BookDto bookDto) {
        List<Book> booksInDb = booksRepository.findByTitle(bookDto.title());
        booksInDb.forEach(book -> {
            if(book.getPublisher().equals(bookDto.publisher())){
                throw new BooksException("Book already exists in the database, with the same publisher");
            }
        });
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate publishDate = LocalDate.parse(bookDto.publicationDate(), formatter);
        Book bookSaved = booksRepository.save(BookMapper.toEntity(bookDto, publishDate, LocalDate.now()));
        return BookMapper.toDto(bookSaved);
    }

    @Override
    public List<BookDto> getAll() {
        return booksRepository.findAll().stream().map(BookMapper::toDto).toList();
    }

    @Override
    public BookDto getBook(String idBook) {
        Optional<Book> foundBook = booksRepository.findById(idBook);
        if(foundBook.isEmpty()){
            throw new BooksException("Book not found!");
        }
        return BookMapper.toDto(foundBook.get());
    }

    @Override
    public List<BookDto> getBookByTitle(String title) {
        return booksRepository.findByTitleContainingIgnoreCase(title).stream().map(BookMapper::toDto).toList();
    }

    @Override
    public List<BookDto> getBookByPublisher(String publisher) {
        return booksRepository.findByPublisherContainingIgnoreCase(publisher).stream().map(BookMapper::toDto).toList();
    }

    @Override
    public List<BookDto> getBookByAuthor(String author) {
        return booksRepository.findByAuthorContainingIgnoreCase(author).stream().map(BookMapper::toDto).toList();
    }

    @Override
    public BookDto update(BookDto bookDto) {
        Optional<Book> foundBook = booksRepository.findById(bookDto.id());
        if(foundBook.isEmpty()){
            throw new BooksException("Book not found!");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate publishDate = LocalDate.parse(bookDto.publicationDate(), formatter);
        Book updatedBook = booksRepository.save(BookMapper.toEntity(bookDto, publishDate, LocalDate.now()));
        return BookMapper.toDto(updatedBook);
    }

    @Override
    public void delete(String idBook) {
        Optional<Book> foundBook = booksRepository.findById(idBook);
        if(foundBook.isEmpty()){
            throw new BooksException("Book not found!");
        }
        booksRepository.deleteById(idBook);
    }
}
