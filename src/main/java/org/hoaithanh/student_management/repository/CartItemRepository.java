package org.hoaithanh.student_management.repository;

import org.hoaithanh.student_management.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// CartItemRepository.java
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    List<CartItem> findByCartIdAndProductId(Long cart_id, Long product_id);

    void deleteByCartIdAndProductId(Long cartId, Long productId);
}

