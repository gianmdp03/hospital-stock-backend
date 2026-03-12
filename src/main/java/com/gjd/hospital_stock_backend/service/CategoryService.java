package com.gjd.hospital_stock_backend.service;

import com.gjd.hospital_stock_backend.dto.category.CategoryDetailDTO;
import com.gjd.hospital_stock_backend.dto.category.CategoryListDTO;
import com.gjd.hospital_stock_backend.dto.category.CategoryRequestDTO;
import com.gjd.hospital_stock_backend.dto.category.CategoryUpdateDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryService {
    CategoryDetailDTO addCategory(CategoryRequestDTO dto);
    CategoryDetailDTO updateCategory(Long id, CategoryUpdateDTO dto);
    Page<CategoryListDTO> listCategories(Pageable pageable);
    CategoryDetailDTO getCategoryById(Long id);
    Page<CategoryListDTO> searchCategories(String name, Pageable pageable);
    void deleteCategory(Long categoryId);
}
