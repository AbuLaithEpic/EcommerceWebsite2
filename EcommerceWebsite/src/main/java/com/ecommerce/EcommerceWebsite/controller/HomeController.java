package com.ecommerce.EcommerceWebsite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/") //GetMapping to index.html
    public String index(){
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @GetMapping("/product")
    public String product(){
        return "product";
    }

    @GetMapping("/view_product")
    public String view_product(){
        return "view_product";
    }

    @GetMapping("/forgot_password")
    public String forgot_password(){
        return "forgot_password";
    }

    @GetMapping("/reset_password")
    public String reset_password(){
        return "reset_password";
    }

//    @GetMapping("/cart")
//    public String cart(){
//        return "cart";
//    }

}
