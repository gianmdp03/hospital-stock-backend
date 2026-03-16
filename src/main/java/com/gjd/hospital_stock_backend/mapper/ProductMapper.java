package com.gjd.hospital_stock_backend.mapper;

import com.gjd.hospital_stock_backend.dto.product.ProductDetailDTO;
import com.gjd.hospital_stock_backend.dto.product.ProductListDTO;
import com.gjd.hospital_stock_backend.dto.product.ProductRequestDTO;
import com.gjd.hospital_stock_backend.dto.product.ProductUpdateDTO;
import com.gjd.hospital_stock_backend.model.Product;
import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class ProductMapper {
    @Autowired
    @Lazy
    private InventoryItemMapper inventoryItemMapper;

    @Autowired
    @Lazy
    private CategoryMapper categoryMapper;

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "inventoryItems", ignore = true)
    @Mapping(target = "categories", ignore = true)
    public abstract Product toEntity(ProductRequestDTO dto);
    public abstract ProductDetailDTO toDetailDto(Product entity);
    public abstract ProductListDTO toListDto(Product entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "inventoryItems", ignore = true)
    @Mapping(target = "categories", ignore = true)
    public abstract void updateEntityFromDto(ProductUpdateDTO dto, @MappingTarget Product product);
}
