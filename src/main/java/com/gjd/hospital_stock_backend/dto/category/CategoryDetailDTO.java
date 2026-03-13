package com.gjd.hospital_stock_backend.dto.category;

import com.gjd.hospital_stock_backend.dto.product.ProductListDTO;

import java.util.List;

public record CategoryDetailDTO(Long id, String name, List<ProductListDTO> product) {
}
