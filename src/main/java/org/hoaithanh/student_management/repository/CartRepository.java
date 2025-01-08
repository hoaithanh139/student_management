package org.hoaithanh.student_management.repository;

import org.hoaithanh.student_management.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

// CartRepository.java
public interface CartRepository extends JpaRepository<Cart, Long> {

    Cart findByUserId(Long userId);
}


