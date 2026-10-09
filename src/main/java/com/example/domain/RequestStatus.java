package com.example.domain;

public sealed interface RequestStatus permits RequestStatus.Draft, RequestStatus.Approved, RequestStatus.Ordered {
    record Draft() implements RequestStatus {}
    record Approved() implements RequestStatus {}
    record Ordered() implements RequestStatus {}
}
