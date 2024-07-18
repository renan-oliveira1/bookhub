package com.bookhub.users.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "USERS")
public class User {
    @Id
    @UuidGenerator
    private String id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private LocalDate birthDate;
    private String phone;
    private UserRoles role;
    private LocalDate created_at;
    private LocalDate updated_at;

    public User(String name, String lastName, String email, String password, LocalDate birthDate, String phone, UserRoles role, LocalDate created_at, LocalDate updated_at) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
        this.phone = phone;
        this.role = role;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
}
