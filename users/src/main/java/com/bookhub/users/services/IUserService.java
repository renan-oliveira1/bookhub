package com.bookhub.users.services;

import com.bookhub.users.dto.UserDto;
import com.bookhub.users.dto.response.UserResponseDto;
import com.bookhub.users.entities.User;
import com.bookhub.users.entities.UserRoles;
import com.bookhub.users.exception.UserException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IUserService {
    UserResponseDto save(UserDto userDto);
    UserResponseDto getUser(String id);
    List<UserResponseDto> getUsers();
    UserResponseDto updateUser(UserDto userDto);
    void deleteUser(String id);
}
