package io.moh.ecommerce.config;

import java.time.Instant;

public record ApiResponse(boolean success, String message) {

    public String getTimeStamp() {
        return Instant.now().toString();
    }
}
