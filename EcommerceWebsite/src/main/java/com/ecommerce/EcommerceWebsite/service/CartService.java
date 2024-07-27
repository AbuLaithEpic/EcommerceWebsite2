package com.ecommerce.EcommerceWebsite.service;

import com.ecommerce.EcommerceWebsite.model.CartItem;
import com.ecommerce.EcommerceWebsite.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public List<CartItem> getCartItems() {
        return cartRepository.findAll();
    }

    public void updateCartItem(Long productId, int quantity) {
        CartItem cartItem = cartRepository.findById(productId).orElseThrow(() -> new IllegalArgumentException("Invalid product ID"));
        cartItem.setQuantity(quantity);
        cartRepository.save(cartItem);
    }

    public void removeCartItem(Long productId) {
        cartRepository.deleteById(productId);
    }

    public double getTotalPrice() {
        return cartRepository.findAll().stream().mapToDouble(item -> item.getPrice() * item.getQuantity()).sum();
    }
}
