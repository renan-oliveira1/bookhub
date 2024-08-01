package com.bookhub.users.services;

import com.bookhub.users.dto.UserDto;
import com.bookhub.users.dto.mapper.UserMapper;
import com.bookhub.users.dto.response.UserResponseDto;
import com.bookhub.users.entities.User;
import com.bookhub.users.entities.UserRoles;
import com.bookhub.users.exception.UserException;
import com.bookhub.users.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class UserService  implements IUserService{
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDto save(UserDto userDto){
        Optional<User> optionalUser = userRepository.findByEmail(userDto.email());
        if (optionalUser.isPresent()){
            throw new UserException("Email already registered!");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate birthDate = LocalDate.parse(userDto.birthDate(), formatter);
        User savedUser = userRepository.save(UserMapper.toEntity(userDto, birthDate, LocalDate.now()));
        return UserMapper.toDto(savedUser);
    }

    @Override
    public UserResponseDto getUser(String id){
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isEmpty()){
            throw new UserException("User not found!");
        }
        return UserMapper.toDto(optionalUser.get());
    }

    @Override
    public List<UserResponseDto> getUsers() {
        return userRepository.findAll().stream().map(UserMapper::toDto).toList();
    }

    @Override
    public UserResponseDto updateUser(UserDto userDto) {
        Optional<User> userFromDb = userRepository.findById(userDto.id());
        if(userFromDb.isEmpty()){
            throw new UserException("User not found!");
        }
        if(!userFromDb.get().getEmail().equals(userDto.email())){
            Optional<User> optionalUserByEmail = userRepository.findByEmail(userDto.email());
            if (optionalUserByEmail.isPresent()){
                throw new UserException("Email already registered!");
            }
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate birthDate = LocalDate.parse(userDto.birthDate(), formatter);
        User updatedUser = userRepository.save(UserMapper.toEntity(userDto, birthDate, LocalDate.now()));
        return UserMapper.toDto(updatedUser);
    }

    @Override
    public void deleteUser(String id){
        Optional<User> userFromDb = userRepository.findById(id);
        if(userFromDb.isEmpty()){
            throw new UserException("User not found!");
        }
        userRepository.deleteById(id);
    }
}
