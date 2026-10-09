package com.example.config;

import com.example.domain.RequestStatus;
import com.example.domain.Rule;
import org.springframework.stereotype.Service;

@Service
public class RequestService {
    private final Rule rules;

    public RequestService(Rule rules) {
        this.rules = rules;
    }

    public RequestStatus move(RequestStatus from, RequestStatus to) {
        rules.check(from, to);
        return to;
    }
}