//package com.ecommerce.EcommerceWebsite.service;
//
//import com.ecommerce.EcommerceWebsite.model.CartItem;
//import com.ecommerce.EcommerceWebsite.model.Order;
//import com.ecommerce.EcommerceWebsite.repository.OrderRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class OrderService {
//
//    @Autowired
//    private OrderRepository orderRepository;
//
//    public Order placeOrder(Order order) {
//        // Calculate the total price from the order's items
//        double totalPrice = order.getItems().stream().mapToDouble(item -> item.getPrice() * item.getQuantity()).sum();
//        order.setTotalPrice(totalPrice);
//
//        // Save the order and return it
//        return orderRepository.save(order);
//    }
//
//    public List<Order> getAllOrders() {
//        return orderRepository.findAll();
//    }
//}
