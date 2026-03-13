package com.gjd.hospital_stock_backend.service.Impl;

import com.gjd.hospital_stock_backend.mapper.InventoryItemMapper;
import com.gjd.hospital_stock_backend.repository.InventoryItemRepository;
import com.gjd.hospital_stock_backend.service.InventoryItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class InventoryItemServiceImpl implements InventoryItemService {
    private final InventoryItemRepository inventoryItemRepository;
    private final InventoryItemMapper inventoryItemMapper;
}
