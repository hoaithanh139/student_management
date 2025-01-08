package org.hoaithanh.student_management.repository;

import org.hoaithanh.student_management.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product getProductsById(Long id);
}
