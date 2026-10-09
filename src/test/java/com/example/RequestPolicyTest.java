package com.example;

import com.example.domain.*;
import com.example.domain.RequestId;
import com.example.domain.RequestPolicy;
import com.example.domain.RequestStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class RequestPolicyTest {

    private final RequestPolicy policy = new RequestPolicy();

    @ParameterizedTest
    @CsvSource({
            "DRAFT, APPROVED, true",
            "APPROVED, ORDERED, true",
            "DRAFT, ORDERED, false",
            "ORDERED, DRAFT, false"
    })
    void testTransitions(String fromStr, String toStr, boolean allowed) {
        RequestStatus from = parseStatus(fromStr);
        RequestStatus to = parseStatus(toStr);

        if (allowed) {
            RequestStatus result = policy.move(from, to);
            assertEquals(to, result);
        } else {
            assertThrows(IllegalStateException.class, () -> policy.move(from, to));
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "   "})
    void testBlankIdThrows(String value) {
        assertThrows(IllegalArgumentException.class, () -> new RequestId(value));
    }

    @Test
    void testNullIdThrows() {
        assertThrows(IllegalArgumentException.class, () -> new RequestId(null));
    }

    private RequestStatus parseStatus(String statusStr) {
        return switch (statusStr) {
            case "DRAFT" -> new RequestStatus.Draft();
            case "APPROVED" -> new RequestStatus.Approved();
            case "ORDERED" -> new RequestStatus.Ordered();
            default -> throw new IllegalArgumentException("Unknown status: " + statusStr);
        };
    }
}