package com.gjd.hospital_stock_backend.service.Impl;

import com.gjd.hospital_stock_backend.mapper.CategoryMapper;
import com.gjd.hospital_stock_backend.repository.CategoryRepository;
import com.gjd.hospital_stock_backend.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
}
