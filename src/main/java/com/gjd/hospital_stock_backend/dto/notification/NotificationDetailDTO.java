package com.gjd.hospital_stock_backend.dto.notification;

import java.time.Instant;

public record NotificationDetailDTO(Long id, String message, Instant date) {
}
