package com.gjd.hospital_stock_backend.repository;

import com.gjd.hospital_stock_backend.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository {
    Page<Category> findAllByNameContainingIgnoreCase(String name, Pageable pageable);
}
