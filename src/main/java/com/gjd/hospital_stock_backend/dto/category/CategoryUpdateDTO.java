package com.gjd.hospital_stock_backend.dto.category;

import java.util.List;

public record CategoryUpdateDTO (String name, List<Long> productIds){
}
