package com.gjd.hospital_stock_backend.dto.inventoryItem;

import com.gjd.hospital_stock_backend.dto.product.ProductListDTO;

import java.time.LocalDate;

public record InventoryItemDetailDTO(Long id, ProductListDTO productListDTO, int stock, LocalDate expireDate) {
}
