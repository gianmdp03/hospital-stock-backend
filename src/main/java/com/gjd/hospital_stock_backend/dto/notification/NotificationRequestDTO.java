package com.gjd.hospital_stock_backend.dto.notification;

import jakarta.validation.constraints.NotBlank;

public record NotificationRequestDTO(@NotBlank String message) {
}
