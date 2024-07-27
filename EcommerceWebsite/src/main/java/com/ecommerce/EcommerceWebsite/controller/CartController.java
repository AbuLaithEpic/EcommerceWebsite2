package com.ecommerce.EcommerceWebsite.controller;

import com.ecommerce.EcommerceWebsite.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/cart")
    public String viewCart(Model model) {
        model.addAttribute("cartItems", cartService.getCartItems());
        model.addAttribute("totalPrice", cartService.getTotalPrice());
        return "cart";
    }

    @PostMapping("/update_cart")
    public String updateCart(@RequestParam("productId") Long productId,
                             @RequestParam("quantity") int quantity) {
        cartService.updateCartItem(productId, quantity);
        return "redirect:/cart";
    }

    @GetMapping("/remove_from_cart")
    public String removeFromCart(@RequestParam("productId") Long productId) {
        cartService.removeCartItem(productId);
        return "redirect:/cart";
    }
}