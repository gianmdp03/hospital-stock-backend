package com.gjd.hospital_stock_backend.repository;

import com.gjd.hospital_stock_backend.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product>  findByIdAndDisabledFalse(Long id );
    Set<Product> findAllByIdInAndDisabledFalse(Iterable<Long> ids);
    Optional<Product> findByName(String name);
    Page<Product> findByDisabledFalse(Pageable pageable);

    Page<Product> findByNameContainingIgnoreCaseAndDisabledTrue(String name, Pageable pageable);

}
