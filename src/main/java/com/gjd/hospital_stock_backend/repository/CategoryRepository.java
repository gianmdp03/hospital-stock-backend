package com.gjd.hospital_stock_backend.repository;

import com.gjd.hospital_stock_backend.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Page<Category> findAllByNameContainingIgnoreCase(String name, Pageable pageable);
    Set<Category> findAllByIdIn(List<Long> ids);
}
