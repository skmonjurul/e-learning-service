package com.example.learningservice.exception;

public record Error(String message) {
    public static Error create(Exception ex) {
        return new Error(ex.getLocalizedMessage());
    }
}
