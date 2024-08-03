// package com.ecommerce.EcommerceWebsite.controller;

// import java.security.Principal;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.core.userdetails.*;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;


// @Controller
// public class CheckoutController {

//     @Autowired
//     private UserDetailsService userDetailsService;

//     @GetMapping("/checkout")
//     public String displayCheckoutPage(Model model, Principal principal) {
//         UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
//         model.addAttribute("userdetail", userDetails);

//         Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//         if (authentication == null || !authentication.isAuthenticated()) {
//             throw new UsernameNotFoundException("User not authenticated");
//         }

//         // CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
//         // Long userId = customUserDetails.getId();

//         // List<Cart> carts = cartService.getCartByUserId(userId);
//         // model.addAttribute("carts", carts);
//         return "order";
//     }
    

// }
