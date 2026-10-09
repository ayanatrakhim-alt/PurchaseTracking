package com.example.domain;

public record RequestId(String value) {
    public RequestId {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Id must not be null or blank");
        }
    }
}