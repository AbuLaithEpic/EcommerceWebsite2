package com.ecommerce.EcommerceWebsite.controller;

import com.ecommerce.EcommerceWebsite.model.CartItem;
import com.ecommerce.EcommerceWebsite.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

//    @GetMapping
//    public String showCart(Model model) {
//        model.addAttribute("cartItems", cartService.getCartItems());
//        model.addAttribute("totalPrice", cartService.getTotalPrice());
//        return "cart";
//    }

    @GetMapping
    public String viewCart(Model model) {
        model.addAttribute("cartItems", cartService.getCartItems());
        model.addAttribute("totalPrice", cartService.getTotalPrice());
        return "cart";
    }

    @PostMapping("/add")
    public String addCartItem(@RequestParam Long productId, @RequestParam int quantity) {
        cartService.addCartItem(productId, quantity);
        return "redirect:/cart";
    }

    @PostMapping("/remove/{id}")
    public String removeCartItem(@PathVariable Long id) {
        cartService.removeCartItem(id);
        return "redirect:/cart";
    }

    @PostMapping("/update/{id}")
    public String updateCartItem(@PathVariable Long id, @RequestParam int quantity) {
        cartService.updateCartItem(id, quantity);
        return "redirect:/cart";
    }
}
