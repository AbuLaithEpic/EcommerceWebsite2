package com.ecommerce.EcommerceWebsite.controller;

import com.ecommerce.EcommerceWebsite.model.Order;
import com.ecommerce.EcommerceWebsite.service.CartService;
import com.ecommerce.EcommerceWebsite.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/checkout")
public class CheckoutController {

    @Autowired
    private CartService cartService;

    @Autowired
    private OrderService orderService;

    @GetMapping
    public String showCheckoutPage(Model model) {
        model.addAttribute("cartItems", cartService.getCartItems());
        model.addAttribute("totalPrice", cartService.getTotalPrice());
        return "checkout";
    }

    @PostMapping
    public String checkout(Order order, Model model) {
        // Set the cart items to the order
        order.setItems(cartService.getCartItems());

        // Place the order
        Order createdOrder = orderService.placeOrder(order);

        // Add the created order to the model
        model.addAttribute("order", createdOrder);
        return "order_confirmation";
    }
}
