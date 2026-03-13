package com.gjd.hospital_stock_backend.dto.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record ProductRequestDTO(@NotBlank String name,
                                @NotEmpty List<Long> categoriesId) {
}
