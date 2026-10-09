package com.example.domain;

public interface Rule {
    void check(RequestStatus from, RequestStatus to);
}
