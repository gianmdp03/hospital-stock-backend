package com.gjd.hospital_stock_backend.mapper;

import com.gjd.hospital_stock_backend.dto.category.CategoryDetailDTO;
import com.gjd.hospital_stock_backend.dto.category.CategoryListDTO;
import com.gjd.hospital_stock_backend.dto.category.CategoryRequestDTO;
import com.gjd.hospital_stock_backend.dto.category.CategoryUpdateDTO;
import com.gjd.hospital_stock_backend.model.Category;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public abstract class CategoryMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "products", ignore = true)
    public abstract Category toEntity(CategoryRequestDTO dto);
    public abstract CategoryDetailDTO toDetailDto(Category entity);
    public abstract CategoryListDTO toListDto(Category entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "products", ignore = true)
    public abstract void updateEntityFromDto(CategoryUpdateDTO dto, @MappingTarget Category entity);
}
