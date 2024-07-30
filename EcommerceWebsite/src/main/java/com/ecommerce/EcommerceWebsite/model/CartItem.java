package com.ecommerce.EcommerceWebsite.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;

@Entity
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartItemId;

    @Column(nullable = false)
    private Long cartId;

    @Column(nullable = false)
    private Long productId;

    @Column(nullable = false)
    private int quantity;

    @ManyToOne
    private Cart cart;

    // Getters and Setters

    public Long getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(Long cartItemId) {
        this.cartItemId = cartItemId;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}

//public class CartItem {
//    private Long id;
//    private Long cartId;
//    private Long productId;
//    private int quantity;
//    private double price;
//
//    // Constructor for mock data
//    public CartItem(Long id, Long cartId, Long productId, int quantity, double price) {
//        this.id = id;
//        this.cartId = cartId;
//        this.productId = productId;
//        this.quantity = quantity;
//        this.price = price;
//    }
//
//    // Getters and setters
//    public Long getId() { return id; }
//    public void setId(Long id) { this.id = id; }
//    public Long getCartId() { return cartId; }
//    public void setCartId(Long cartId) { this.cartId = cartId; }
//    public Long getProductId() { return productId; }
//    public void setProductId(Long productId) { this.productId = productId; }
//    public int getQuantity() { return quantity; }
//    public void setQuantity(int quantity) { this.quantity = quantity; }
//    public double getPrice() { return price; }
//    public void setPrice(double price) { this.price = price; }
//}
