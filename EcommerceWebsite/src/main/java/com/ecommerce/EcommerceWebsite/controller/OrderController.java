package com.ecommerce.EcommerceWebsite.controller;

import java.security.Principal;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecommerce.EcommerceWebsite.config.CustomUserDetails;
import com.ecommerce.EcommerceWebsite.model.Cart;
import com.ecommerce.EcommerceWebsite.model.Order;
import com.ecommerce.EcommerceWebsite.model.OrderItem;
import com.ecommerce.EcommerceWebsite.repository.OrderRepository;
import com.ecommerce.EcommerceWebsite.service.*;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private CartService cartService;

    @Autowired
    private OrderItemService orderItemService;

    // Handling requests to the '/checkout' endpoint
    @GetMapping("/checkout")
    public String displayCheckoutPage(Model model, Principal principal) {
        // Retrieve the details of the currently authenticated user
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("userdetail", userDetails);

        // Check if the user is authenticated. If the user is not authenticated, it will throws an exception to ensure that only authenticated users can access the checkout page
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new UsernameNotFoundException("User not authenticated");
        }

        // Get the userId by 'CustomeUserDetails' from the 'Authentication' object
        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
        Long userId = customUserDetails.getId();

        // Retrieves the list of cart items based on user id. Added the list to the model with the attributes name 'carts'
        List<Cart> carts = cartService.getCartByUserId(userId);
        model.addAttribute("carts", carts);

        // Calculates the total price of the items in the cart by calling the method calculateTotalPrice(Long userId) from Cart Service. Added the totalPrice data to the model attribute name 'totalPrice'
        double totalPrice = cartService.calculateTotalPrice(userId);
        model.addAttribute("totalPrice", totalPrice);

        model.addAttribute("carts_length", carts.size());
        return "checkout";
    }

    @PostMapping("/checkout")
    public String processOrder(@RequestParam("fullname") String fullname, @RequestParam("email") String email, @RequestParam("phone") int phone, @RequestParam("billingAddress") String billingAddress, Principal principal) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        Long userId = ((CustomUserDetails) userDetails).getId();

        // Create order with billing address and items from cart
        orderService.createOrder(fullname, phone, email, billingAddress, userId, "Successful");

        return "success"; // Redirect to an order confirmation page
    }

    @GetMapping("/my-orders") //GetMapping to index.html
    public String displayOrderById(Model model, Principal principal){

        //to get user detail when appear "welcome user's name"
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("userdetail", userDetails);


        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new UsernameNotFoundException("User not authenticated");
        }

        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
        Long userId = customUserDetails.getId();

        List<Order> orders = orderService.getOrderByUserId(userId);

        // Format the dates
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        for (Order order : orders) {
            order.setFormattedDate(order.getCreatedAt().format(formatter));
        }

        // Create a map to store order items by order ID
        Map<Long, List<OrderItem>> orderItemsMap = new HashMap<>();
        for (Order order : orders) {
            Long orderId = order.getId();
            List<OrderItem> orderItems = orderItemService.getOrderItemByOrderId(orderId);
            orderItemsMap.put(orderId, orderItems);
        }

        // for (Order order : orders) {
        //     Long orderId = order.getId();
        //     List<OrderItem> orderItems = orderItemService.getOrderItemByOrderId(orderId);
        //     model.addAttribute("orderItems_"+orderId, orderItems);
        // }

        model.addAttribute("orders", orders);
        model.addAttribute("orderItemsMap", orderItemsMap);

        List<Cart> carts = cartService.getCartByUserId(userId);

        model.addAttribute("carts_length", carts.size());

        return "my_orders";
    }
    
}