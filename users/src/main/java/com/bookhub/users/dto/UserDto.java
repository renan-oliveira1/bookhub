package com.bookhub.users.dto;


public record UserDto(String id, String name, String lastName, String email, String password, String birthDate, String phone, String role) {
}
