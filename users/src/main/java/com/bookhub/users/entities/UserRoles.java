package com.bookhub.users.entities;

public enum UserRoles {
    ADMIN("ADMIN"),
    USER("USER");

    private String role;

    UserRoles(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
