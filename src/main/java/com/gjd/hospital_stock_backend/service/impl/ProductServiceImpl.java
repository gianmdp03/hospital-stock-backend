package com.gjd.hospital_stock_backend.service.impl;


import com.gjd.hospital_stock_backend.dto.product.ProductDetailDTO;
import com.gjd.hospital_stock_backend.dto.product.ProductListDTO;
import com.gjd.hospital_stock_backend.dto.product.ProductRequestDTO;
import com.gjd.hospital_stock_backend.dto.product.ProductUpdateDTO;
import com.gjd.hospital_stock_backend.exception.NotFoundException;
import com.gjd.hospital_stock_backend.mapper.ProductMapper;
import com.gjd.hospital_stock_backend.model.Category;
import com.gjd.hospital_stock_backend.model.Product;
import com.gjd.hospital_stock_backend.repository.CategoryRepository;
import com.gjd.hospital_stock_backend.repository.ProductRepository;
import com.gjd.hospital_stock_backend.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final CategoryRepository categoryRepository;

    @Override
    @Transactional
    public ProductDetailDTO addProduct(ProductRequestDTO dto) {
        Optional<Product> optionalProduct = productRepository.findByName(dto.name());
        Set<Category> categories = categoryRepository.findAllByIdIn(dto.categoriesId());
        if(categories.isEmpty())
            throw new NotFoundException("List is empty");
        if(optionalProduct.isPresent()){
            Product existingProduct = optionalProduct.get();
            existingProduct.setDisabled(false);
            existingProduct.setCategories(categories);
            existingProduct = productRepository.save(existingProduct);
            return productMapper.toDetailDto(existingProduct);
        }
        Product product = productMapper.toEntity(dto);
        product.setCategories(categories);
        product = productRepository.save(product);
        return productMapper.toDetailDto(product);
    }

    @Override
    @Transactional
    public ProductDetailDTO updateProduct(Long id, ProductUpdateDTO dto) {
        Product product = productRepository.findByIdAndDisabledFalse(id).orElseThrow(()-> new NotFoundException("Product id does not exist"));
        productMapper.updateEntityFromDto(dto,product);
        if(dto.categoriesId() != null && !dto.categoriesId().isEmpty()){
            Set<Category> categories = categoryRepository.findAllByIdIn(dto.categoriesId());
            product.setCategories(categories);
        }
        product = productRepository.save(product);
        return productMapper.toDetailDto(product);
    }

    @Override
    public Page<ProductListDTO> listProducts(Pageable pageable) {
        Page<Product> page = productRepository.findByDisabledFalse(pageable);
        if (page.isEmpty())
            throw new NotFoundException("List is empty");
        return page.map(productMapper::toListDto);
    }

    @Override
    public Page<ProductListDTO> searchProductsByName(String name, Pageable pageable){
        if(name == null || name.isBlank()){
            return Page.empty();
        }
        Page<Product> page = productRepository.findByNameContainingIgnoreCaseAndDisabledTrue(name, pageable);
        return page.map(productMapper::toListDto);
    }

    @Override
    public ProductDetailDTO getProductById(Long id){
        Product product = productRepository.findByIdAndDisabledFalse(id)
                .orElseThrow(()-> new NotFoundException("Product ID does not exist"));
        return productMapper.toDetailDto(product);
    }

    @Override
    @Transactional
    public void deleteProduct(Long productId) {
        Product product = productRepository.findByIdAndDisabledFalse(productId).orElseThrow(()->new NotFoundException("Product ID does not exist"));
        product.setDisabled(true);
        productRepository.save(product);
    }
}
