package com.ecommerce.EcommerceWebsite.service;

import com.ecommerce.EcommerceWebsite.model.Cart;
import com.ecommerce.EcommerceWebsite.model.CartItem;
import com.ecommerce.EcommerceWebsite.repository.CartRepository;
import com.ecommerce.EcommerceWebsite.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Override
    public Cart getCartByUserId(Long userId) {
        return cartRepository.findByUserId(userId).orElse(new Cart());
    }

    @Override
    public void addItemToCart(Long userId, Long productId, int quantity) {
        Cart cart = cartRepository.findByUserId(userId).orElse(new Cart());
        // Logic to add item to the cart
        CartItem cartItem = new CartItem();
        cartItem.setCartId(cart.getCartId());
        cartItem.setProductId(productId);
        cartItem.setQuantity(quantity);
        cartItemRepository.save(cartItem);
    }

    @Override
    public void updateCartItem(Long cartItemId, int quantity) {
        CartItem cartItem = cartItemRepository.findById(cartItemId).orElseThrow();
        cartItem.setQuantity(quantity);
        cartItemRepository.save(cartItem);
    }

    @Override
    public void removeCartItem(Long cartItemId) {
        cartItemRepository.deleteById(cartItemId);
    }
}
