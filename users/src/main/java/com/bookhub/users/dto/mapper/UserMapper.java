package com.bookhub.users.dto.mapper;

import com.bookhub.users.dto.UserDto;
import com.bookhub.users.dto.response.UserResponseDto;
import com.bookhub.users.entities.User;
import com.bookhub.users.entities.UserRoles;

import java.time.LocalDate;

public class UserMapper {
    private UserMapper(){

    }

    public static User toEntity(UserDto userDto, LocalDate birthDate, LocalDate updatedDate){
        return new User(
                userDto.id(), userDto.name(), userDto.lastName(), userDto.email(),
                userDto.password(), birthDate, userDto.phone(), UserRoles.valueOf(userDto.role()),
                LocalDate.now(), updatedDate
        );
    }

    public static UserResponseDto toDto(User user){
        return new UserResponseDto(
                user.getId(), user.getName(), user.getLastName(), user.getEmail(), user.getBirthDate().toString(),
                user.getPhone(), user.getRole().toString(), user.getCreated_at().toString(), user.getUpdated_at().toString()
        );
    }

}
