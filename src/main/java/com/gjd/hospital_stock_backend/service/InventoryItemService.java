package com.gjd.hospital_stock_backend.service;

import com.gjd.hospital_stock_backend.dto.inventoryItem.InventoryItemDetailDTO;
import com.gjd.hospital_stock_backend.dto.inventoryItem.InventoryItemRequestDTO;
import com.gjd.hospital_stock_backend.dto.inventoryItem.InventoryItemUpdateDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface InventoryItemService {

    InventoryItemDetailDTO addInventoryItem(InventoryItemRequestDTO dto);
    InventoryItemDetailDTO updateInventoryItem(Long id, InventoryItemUpdateDTO dto);
    Page<InventoryItemDetailDTO> listInventoryItems(Pageable pageable);
    InventoryItemDetailDTO getInventoryItemById(Long id);
    void deleteInventoryItem(Long inventoryItemId);

    List<InventoryItemDetailDTO> getTopStockItems();
    List<InventoryItemDetailDTO> getLowStockItems(int stockLimit);

    Page<InventoryItemDetailDTO> searchByProductName(String name, Pageable pageable);
}
