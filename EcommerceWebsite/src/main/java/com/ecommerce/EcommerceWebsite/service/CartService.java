package com.ecommerce.EcommerceWebsite.service;

import com.ecommerce.EcommerceWebsite.model.Cart;
import com.ecommerce.EcommerceWebsite.model.CartItem;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface CartService {

        Cart getCartByUserId(Long userId);
        void addItemToCart(Long userId, Long productId, int quantity);
        void updateCartItem(Long cartItemId, int quantity);
        void removeCartItem(Long cartItemId);


    // Simulate a method to get cart items. In a real application, this would query a repository.
//    public List<CartItem> getCartItems(Long cartId) {
//        // Mock data for demonstration purposes
//        List<CartItem> cartItems = new ArrayList<>();
//        // Adding some dummy cart items
//        cartItems.add(new CartItem(1L, cartId, 101L, 2, 10.00));
//        cartItems.add(new CartItem(2L, cartId, 102L, 1, 20.00));
//        return cartItems;
//    }
}
