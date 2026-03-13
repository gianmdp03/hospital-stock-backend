package com.gjd.hospital_stock_backend.mapper;

import com.gjd.hospital_stock_backend.dto.inventoryItem.InventoryItemDetailDTO;
import com.gjd.hospital_stock_backend.dto.inventoryItem.InventoryItemRequestDTO;
import com.gjd.hospital_stock_backend.dto.inventoryItem.InventoryItemUpdateDTO;
import com.gjd.hospital_stock_backend.model.InventoryItem;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public abstract class InventoryItemMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "product", ignore = true)
    public abstract InventoryItem toEntity(InventoryItemRequestDTO dto);
    public abstract InventoryItemDetailDTO toDetailDTO(InventoryItem entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "product", ignore = true)
    public abstract void updateEntityFromDto(InventoryItemUpdateDTO dto, @MappingTarget InventoryItem entity);
}
