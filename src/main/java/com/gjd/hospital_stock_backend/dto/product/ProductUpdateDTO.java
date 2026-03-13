package com.gjd.hospital_stock_backend.dto.product;

import java.util.List;

public record ProductUpdateDTO(String name,
                               List<Long> categoriesId) {
}
