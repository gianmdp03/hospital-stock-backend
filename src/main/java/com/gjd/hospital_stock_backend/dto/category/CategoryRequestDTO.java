package com.gjd.hospital_stock_backend.dto.category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record CategoryRequestDTO(@NotBlank String name,
                                 @NotEmpty List<Long> productIds) {
}
