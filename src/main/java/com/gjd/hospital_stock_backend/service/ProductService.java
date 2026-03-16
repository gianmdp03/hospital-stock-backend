package com.gjd.hospital_stock_backend.service;

import com.gjd.hospital_stock_backend.dto.product.ProductDetailDTO;
import com.gjd.hospital_stock_backend.dto.product.ProductListDTO;
import com.gjd.hospital_stock_backend.dto.product.ProductRequestDTO;
import com.gjd.hospital_stock_backend.dto.product.ProductUpdateDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    ProductDetailDTO addProduct(ProductRequestDTO dto);
    Page<ProductListDTO> listProducts(Pageable pageable);
    ProductDetailDTO updateProduct(Long id, ProductUpdateDTO dto);
    Page<ProductListDTO> searchProductsByName(String name, Pageable pageable);
    ProductDetailDTO getProductById(Long id);
    void deleteProduct(Long productId);
}
