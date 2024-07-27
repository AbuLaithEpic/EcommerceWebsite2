package com.ecommerce.EcommerceWebsite.repository;

import com.ecommerce.EcommerceWebsite.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<CartItem, Long> {
}
