//package com.ecommerce.EcommerceWebsite.controller;
//
//import com.ecommerce.EcommerceWebsite.model.CartItem;
//import com.ecommerce.EcommerceWebsite.service.CartService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//
//import java.util.List;
//
//@Controller
//@RequestMapping("/cart")
//public class CartController {
//
//    @Autowired
//    private CartService cartService;
//
//    @GetMapping("/view")
//    public String viewCart(@RequestParam("cartId") Long cartId, Model model) {
//        // Get the cart items using the CartService
//        List<CartItem> cartItems = cartService.getCartItems(cartId);
//
//        // Calculate total price
//        double totalPrice = cartItems.stream()
//                .mapToDouble(item -> item.getPrice() * item.getQuantity())
//                .sum();
//
//        // Add attributes to the model
//        model.addAttribute("cartItems", cartItems);
//        model.addAttribute("totalPrice", totalPrice);
//
//        // Return the Thymeleaf template name
//        return "cart"; // This should match your Thymeleaf template file name
//    }
//}
