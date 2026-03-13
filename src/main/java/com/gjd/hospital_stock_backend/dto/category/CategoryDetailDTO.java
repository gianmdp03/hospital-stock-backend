package com.gjd.hospital_stock_backend.dto.category;

import com.gjd.hospital_stock_backend.dto.product.ProductListDTO;

public record CategoryDetailDTO(Long id, ProductListDTO productListDTO) {
}
