package com.gjd.hospital_stock_backend.service.Impl;


import com.gjd.hospital_stock_backend.mapper.ProductMapper;
import com.gjd.hospital_stock_backend.repository.ProductRepository;
import com.gjd.hospital_stock_backend.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
}
