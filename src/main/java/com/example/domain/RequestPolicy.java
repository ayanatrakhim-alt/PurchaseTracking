package com.example.domain;

public class RequestPolicy {
    public RequestStatus move(RequestStatus from, RequestStatus to) {
        if (from == null || to == null) {
            throw new IllegalArgumentException("Statuses must not be null");
        }

        if (from instanceof RequestStatus.Draft && to instanceof RequestStatus.Approved) {
            return to;
        }

        if (from instanceof RequestStatus.Approved && to instanceof RequestStatus.Ordered) {
            return to;
        }

        throw new IllegalStateException("Transition from " + from.getClass().getSimpleName()
                + " to " + to.getClass().getSimpleName() + " is forbidden");
    }
}