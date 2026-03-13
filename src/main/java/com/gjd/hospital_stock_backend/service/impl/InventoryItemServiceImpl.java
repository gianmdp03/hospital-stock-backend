package com.gjd.hospital_stock_backend.service.Impl;

import com.gjd.hospital_stock_backend.dto.inventoryItem.InventoryItemDetailDTO;
import com.gjd.hospital_stock_backend.dto.inventoryItem.InventoryItemRequestDTO;
import com.gjd.hospital_stock_backend.dto.inventoryItem.InventoryItemUpdateDTO;
import com.gjd.hospital_stock_backend.exception.NotFoundException;
import com.gjd.hospital_stock_backend.mapper.InventoryItemMapper;
import com.gjd.hospital_stock_backend.model.InventoryItem;
import com.gjd.hospital_stock_backend.model.Product;
import com.gjd.hospital_stock_backend.repository.InventoryItemRepository;
import com.gjd.hospital_stock_backend.repository.ProductRepository;
import com.gjd.hospital_stock_backend.service.InventoryItemService;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Override
    @Transactional
    public InventoryItemDetailDTO updateInventoryItem(Long id, InventoryItemUpdateDTO dto){
        InventoryItem  inventoryItem = inventoryItemRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Inventory Item ID does not exist"));
        inventoryItemMapper.updateEntityFromDto(dto,inventoryItem);
        inventoryItemRepository.save(inventoryItem);
        return inventoryItemMapper.toDetailDTO(inventoryItem);
    }

    @Override
    public Page<InventoryItemDetailDTO> listInventoryItems(Pageable pageable) {
        Page<InventoryItem> page = inventoryItemRepository.findAll(pageable);
        if(page.isEmpty()){
            return Page.empty();
        }

        return page.map(inventoryItemMapper::toDetailDTO);
    }

    @Override
    public Page<InventoryItemDetailDTO> searchByProductName(String name, Pageable pageable) {
        Page<InventoryItem> items = inventoryItemRepository.findByProduct_NameContainingIgnoreCase(name, pageable);
        return items.map(inventoryItemMapper::toDetailDTO);
    }

    @Override
    public InventoryItemDetailDTO getInventoryItemById(Long id) {
        InventoryItem inventoryItem = inventoryItemRepository.findById(id).orElseThrow(()-> new NotFoundException("Inventory Item ID does not exist"));
        return inventoryItemMapper.toDetailDTO(inventoryItem);
    }

    @Override
    @Transactional
    public void deleteInventoryItem(Long id) {
        InventoryItem inventoryItem = inventoryItemRepository.findById(id).orElseThrow(()-> new NotFoundException("Inventory Item ID does not exist"));
        inventoryItemRepository.delete(inventoryItem);
    }

    
}
