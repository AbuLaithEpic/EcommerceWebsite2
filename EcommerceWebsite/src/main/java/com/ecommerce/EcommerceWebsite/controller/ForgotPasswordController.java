package com.ecommerce.EcommerceWebsite.controller;

import com.ecommerce.EcommerceWebsite.service.PasswordResetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/forgot-password")
public class ForgotPasswordController {

    @Autowired
    private PasswordResetService passwordResetService;

    @GetMapping
    public String showForgotPasswordForm() {
        return "forgot-password";
    }

    @PostMapping
    public String processForgotPassword(@RequestParam("phone") String phone, RedirectAttributes redirectAttributes) {
        boolean codeSent = passwordResetService.sendVerificationCode(phone);
        if (codeSent) {
            redirectAttributes.addFlashAttribute("phone", phone);
            return "redirect:/verify-code";
        } else {
            redirectAttributes.addFlashAttribute("error", "Phone number not found.");
            return "redirect:/forgot-password";
        }
    }
}
