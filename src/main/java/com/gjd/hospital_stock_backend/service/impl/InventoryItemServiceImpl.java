package com.gjd.hospital_stock_backend.service.Impl;

import com.gjd.hospital_stock_backend.dto.inventoryItem.InventoryItemDetailDTO;
import com.gjd.hospital_stock_backend.dto.inventoryItem.InventoryItemRequestDTO;
import com.gjd.hospital_stock_backend.exception.NotFoundException;
import com.gjd.hospital_stock_backend.mapper.InventoryItemMapper;
import com.gjd.hospital_stock_backend.model.InventoryItem;
import com.gjd.hospital_stock_backend.model.Product;
import com.gjd.hospital_stock_backend.repository.InventoryItemRepository;
import com.gjd.hospital_stock_backend.repository.ProductRepository;
import com.gjd.hospital_stock_backend.service.InventoryItemService;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class InventoryItemServiceImpl implements InventoryItemService {
    private final InventoryItemRepository inventoryItemRepository;
    private final InventoryItemMapper inventoryItemMapper;
    private final ProductRepository productRepository;

    @Override
    public InventoryItemDetailDTO addInventoryItem(InventoryItemRequestDTO dto) {
        Product product = productRepository.findByIdAndDisabledTrue(dto.productId())
                .orElseThrow(()-> new NotFoundException("Product ID does not exist"));
        InventoryItem inventoryItem = inventoryItemMapper.toEntity(dto);
        inventoryItem.setProduct(product);
        inventoryItemRepository.save(inventoryItem);
        return inventoryItemMapper.toDetailDTO(inventoryItem);

    }
    
}
