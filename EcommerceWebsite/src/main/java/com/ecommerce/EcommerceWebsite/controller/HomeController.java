
package com.ecommerce.EcommerceWebsite.controller;

import com.ecommerce.EcommerceWebsite.model.Cart;
import com.ecommerce.EcommerceWebsite.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    private CartService cartService;

    @GetMapping("/cart")
    public String viewCart(Model model, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/cartView";
        }
        Cart cart = cartService.getCartByUserId(userId);
        model.addAttribute("cart", cart);
        return "cartView";
    }

    @PostMapping("/cart/add")
    public String addToCart(@RequestParam Long productId, @RequestParam int quantity, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/login";
        }
        cartService.addItemToCart(userId, productId, quantity);
        return "redirect:/cart";
    }

    @PostMapping("/cart/edit")
    public String editCartItem(@RequestParam Long cartItemId, @RequestParam int quantity) {
        cartService.updateCartItem(cartItemId, quantity);
        return "redirect:/cart";
    }

    @PostMapping("/cart/remove")
    public String removeCartItem(@RequestParam Long cartItemId) {
        cartService.removeCartItem(cartItemId);
        return "redirect:/cart";
    }

    // Add checkout methods if needed
}

//package com.ecommerce.EcommerceWebsite.controller;
//
//import com.ecommerce.EcommerceWebsite.model.Cart;
//import jakarta.servlet.http.HttpSession;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//@Controller
//public class HomeController {
//
//    @GetMapping("/cart")
//    public String viewCart(Model model, HttpSession session) {
//        Long userId = (Long) session.getAttribute("userId"); // Retrieve userId from session
//        if (userId == null) {
//            return "redirect:/login"; // Redirect to login if not authenticated
//        }
//        Cart cart = cartService.getCartByUserId(userId);
//        model.addAttribute("cart", cart);
//        return "cartView";  // Thymeleaf template to display the cart
//    }
//
//
////    @GetMapping("/") //GetMapping to index.html
////    public String index(){
////        return "index";
////    }
////
////    @GetMapping("/login")
////    public String login(){
////        return "login";
////    }
////
////    @GetMapping("/register")
////    public String register(){
////        return "register";
////    }
//
////    @GetMapping("/product")
////    public String product(){
////        return "product";
////    }
////
////    @GetMapping("/view_product")
////    public String view_product(){
////        return "view_product";
////    }
////
////    @GetMapping("/forgot_password")
////    public String forgot_password(){
////        return "forgot_password";
////    }
////
////    @GetMapping("/reset_password")
////    public String reset_password(){
////        return "reset_password";
////    }
//
////    @GetMapping("/cart")
////    public String cart(){
////        return "cart";
////    }
//
////    @GetMapping("/checkout")
////    public String checkout(){
////        return "checkout";
////    }
//
////    @GetMapping("/cart")
////    public String cart(){
////        return "cart";
////    }
//
//}
