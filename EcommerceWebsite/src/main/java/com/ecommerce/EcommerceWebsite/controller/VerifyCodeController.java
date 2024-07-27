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
@RequestMapping("/verify-code")
public class VerifyCodeController {

    @Autowired
    private PasswordResetService passwordResetService;

    @GetMapping
    public String showVerifyCodeForm(@RequestParam("phone") String phone) {
        return "verify-code";
    }

    @PostMapping
    public String verifyCode(@RequestParam("phone") String phone,
                             @RequestParam("code") String code,
                             RedirectAttributes redirectAttributes) {
        boolean isValid = passwordResetService.verifyCode(phone, code);
        if (isValid) {
            redirectAttributes.addFlashAttribute("phone", phone);
            redirectAttributes.addFlashAttribute("code", code);
            return "redirect:/reset-password";
        } else {
            redirectAttributes.addFlashAttribute("error", "Invalid verification code.");
            return "redirect:/verify-code";
        }
    }
}
