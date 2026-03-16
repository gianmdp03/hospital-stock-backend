package com.gjd.hospital_stock_backend.service.impl;

import com.gjd.hospital_stock_backend.dto.category.CategoryDetailDTO;
import com.gjd.hospital_stock_backend.dto.category.CategoryListDTO;
import com.gjd.hospital_stock_backend.dto.category.CategoryRequestDTO;
import com.gjd.hospital_stock_backend.dto.category.CategoryUpdateDTO;
import com.gjd.hospital_stock_backend.exception.NotFoundException;
import com.gjd.hospital_stock_backend.mapper.CategoryMapper;
import com.gjd.hospital_stock_backend.model.Category;
import com.gjd.hospital_stock_backend.repository.CategoryRepository;
import com.gjd.hospital_stock_backend.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    @Transactional
    public CategoryDetailDTO addCategory(CategoryRequestDTO dto) {
        Category category = categoryRepository.save(categoryMapper.toEntity(dto));
        return categoryMapper.toDetailDto(category);
    }

    @Override
    @Transactional
    public CategoryDetailDTO updateCategory(Long id, CategoryUpdateDTO dto){
        Category category = categoryRepository.findById(id).orElseThrow(()->new NotFoundException("Category ID does not exist"));
        categoryMapper.updateEntityFromDto(dto, category);
        category = categoryRepository.save(category);
        return categoryMapper.toDetailDto(category);
    }

    @Override
    public Page<CategoryListDTO> listCategories(Pageable pageable) {
        Page<Category> categoryPage = categoryRepository.findAll(pageable);
        if(categoryPage.isEmpty()){
            throw new NotFoundException("List is empty");
        }
        return categoryPage.map(categoryMapper::toListDto);
    }

    @Override
    public CategoryDetailDTO getCategoryById(Long id){
        Category category = categoryRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Category ID does not exist"));
        return categoryMapper.toDetailDto(category);
    }

    @Override
    public Page<CategoryListDTO> searchCategories(String name, Pageable pageable){
        if(name == null || name.isBlank()){
            return Page.empty();
        }
        Page<Category> page = categoryRepository.findAllByNameContainingIgnoreCase(name, pageable);
        return page.map(categoryMapper::toListDto);
    }

    @Override
    @Transactional
    public void deleteCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(()-> new NotFoundException("Category ID does not exist"));
        categoryRepository.delete(category);
    }
}
