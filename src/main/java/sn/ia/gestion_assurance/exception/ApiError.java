package sn.ia.gestion_assurance.exception;

import java.time.LocalDateTime;
import java.util.Map;

public record ApiError(
        int status,
        String message,
        LocalDateTime timestamp,
        Map<String, String> errors
) {
    public ApiError(int status, String message, LocalDateTime timestamp) {
        this(status, message, timestamp, null);
    }
}
