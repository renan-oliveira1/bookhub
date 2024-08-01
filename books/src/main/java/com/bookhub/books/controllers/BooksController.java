package com.bookhub.books.controllers;

import com.bookhub.books.dto.BookDto;
import com.bookhub.books.services.IBooksService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/books")
public class BooksController {
    private IBooksService iBooksService;

    public BooksController(IBooksService iBooksService) {
        this.iBooksService = iBooksService;
    }

    @PostMapping()
    public ResponseEntity<BookDto> save(@RequestBody BookDto bookDto){
        BookDto savedBook = iBooksService.save(bookDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
    }

    @GetMapping()
    public ResponseEntity<List<BookDto>> getAllBooks(){
        return ResponseEntity.status(HttpStatus.OK).body(iBooksService.getAll());
    }

    @GetMapping("/id/{idBook}")
    public ResponseEntity<BookDto> getBookById(@PathVariable String idBook){
        return ResponseEntity.status(HttpStatus.OK).body(iBooksService.getBook(idBook));
    }

    @GetMapping("/author/{author}")
    public ResponseEntity<List<BookDto>> getBookByAuthor(@PathVariable String author){
        return ResponseEntity.status(HttpStatus.OK).body(iBooksService.getBookByAuthor(author));
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<List<BookDto>> getBookByTitle(@PathVariable String title){
        return ResponseEntity.status(HttpStatus.OK).body(iBooksService.getBookByTitle(title));
    }

    @PutMapping()
    public ResponseEntity<BookDto> update(@RequestBody BookDto bookDto){
        return ResponseEntity.status(HttpStatus.OK).body(iBooksService.update(bookDto));
    }

    @DeleteMapping("/{idBook}")
    public ResponseEntity<Object> delete(@PathVariable String idBook){
        iBooksService.delete(idBook);
        return ResponseEntity.status(HttpStatus.OK).body("Book deleted!");
    }
}
