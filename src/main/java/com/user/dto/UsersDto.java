package com.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class UsersDto {
    private Long id;

    @NotNull(message = "Should enter a valid first name!")
    private String firstName;

    @NotNull(message = "Should enter a valid last name!")
    private String lastName;

    @Email
    @NotNull(message = "Should enter a valid email")
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
