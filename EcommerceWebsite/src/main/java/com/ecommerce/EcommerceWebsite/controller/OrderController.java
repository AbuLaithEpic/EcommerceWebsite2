//package com.ecommerce.EcommerceWebsite.controller;
//
//import com.ecommerce.EcommerceWebsite.model.Order;
//import com.ecommerce.EcommerceWebsite.service.OrderService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping("/order")
//public class OrderController {
//
//    @Autowired
//    private OrderService orderService;
//
//    @PostMapping("/create")
//    public String createOrder(Order order, Model model) {
//        Order createdOrder = orderService.placeOrder(order);
//        model.addAttribute("order", createdOrder);
//        return "order_confirmation";
//    }
//}
