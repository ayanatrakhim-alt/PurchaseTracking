package com.example.domain;

import java.util.List;

public class CompositeRule implements Rule {
    private final List<Rule> rules;

    public CompositeRule(List<Rule> rules) {
        this.rules = rules;
    }

    @Override
    public void check(RequestStatus from, RequestStatus to) {
        for (Rule rule : rules) {
            rule.check(from, to);
        }
    }
}
