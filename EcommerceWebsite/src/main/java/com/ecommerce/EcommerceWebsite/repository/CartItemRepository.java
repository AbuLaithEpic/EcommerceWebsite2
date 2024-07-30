package com.ecommerce.EcommerceWebsite.repository;

//package com.ecommerce.EcommerceWebsite.repository;

import com.ecommerce.EcommerceWebsite.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}


//import com.ecommerce.EcommerceWebsite.model.CartItem;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.List;
//import java.util.Optional;
//
//public interface CartItemRepository extends JpaRepository<CartItem, Long> {
//    void deleteByCartId(Long cartId);
//    List<CartItem> findByCartId(Long cartId);
//    Optional<CartItem> findByCartIdAndProductId(Long cartId, Long productId);
//}
