package com.gjd.hospital_stock_backend.dto.inventoryItem;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record InventoryItemRequestDTO(@NotNull Long productId,
                                      @NotNull int stock,
                                      @NotNull  @Future LocalDate expireDate) {}
