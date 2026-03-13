package com.gjd.hospital_stock_backend.dto.product;

import com.gjd.hospital_stock_backend.dto.category.CategoryListDTO;

import java.util.List;

public record ProductDetailDTO(Long id, String name, List<CategoryListDTO> categories, int stock) {
}
