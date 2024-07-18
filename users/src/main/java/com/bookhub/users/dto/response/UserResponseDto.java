package com.bookhub.users.dto.response;

public record UserResponseDto(String id, String name, String lastName,
                              String email, String birthDate, String phone,
                              String role, String createdAt, String updatedAt) {
}
