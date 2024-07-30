package com.ecommerce.EcommerceWebsite.repository;

//package com.ecommerce.EcommerceWebsite.repository;

import com.ecommerce.EcommerceWebsite.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {
   Optional<Cart> findByUserId(Long userId);
//Cart findByUserId(Long userId);
}


//import com.ecommerce.EcommerceWebsite.model.Cart;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.Optional;
//
//public interface CartRepository extends JpaRepository<Cart, Long> {
//    Optional<Cart> findByUserId(Long userId);
//}
