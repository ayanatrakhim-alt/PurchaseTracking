package com.example.domain;

public class UnapprovedCannotOrder implements Rule {
    @Override
    public void check(RequestStatus from, RequestStatus to) {
        if (from instanceof RequestStatus.Draft && to instanceof RequestStatus.Ordered) {
            throw new IllegalStateException("Cannot order a draft request directly without approval");
        }
    }
}
