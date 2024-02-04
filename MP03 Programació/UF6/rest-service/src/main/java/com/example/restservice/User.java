package com.example.restservice;

public record User(Integer id, String email, String fullName, String password) {

    public User withEmail(String email) {
        return new User(this.id(), email, this.fullName(), this.password());
    }

    public User withFullName(String fullName) {
        return new User(this.id(), this.email(), fullName, this.password());
    }

    public User withPassword(String password) {
        return new User(this.id(), this.email(), this.fullName(), password);
    }
}
