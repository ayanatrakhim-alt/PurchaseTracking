package com.example.domain;

public class TransitionRule implements Rule {
    private final RequestPolicy policy;

    public TransitionRule(RequestPolicy policy) {
        this.policy = policy;
    }

    @Override
    public void check(RequestStatus from, RequestStatus to) {
        policy.move(from, to);
    }
}