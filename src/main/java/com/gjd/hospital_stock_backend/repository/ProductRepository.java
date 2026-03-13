package com.gjd.hospital_stock_backend.repository;

import com.gjd.hospital_stock_backend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product>  findByIdAndDisabledTrue(Long id );
    }
