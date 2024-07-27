package com.ecommerce.EcommerceWebsite.controller;

import com.ecommerce.EcommerceWebsite.service.PasswordResetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/reset-password")
public class ResetPasswordController {

    @Autowired
    private PasswordResetService passwordResetService;

    @PostMapping
    public String resetPassword(@RequestParam("phone") String phone,
                                @RequestParam("code") String code,
                                @RequestParam("password") String newPassword,
                                RedirectAttributes redirectAttributes) {
        boolean resetSuccessful = passwordResetService.resetPassword(phone, code, newPassword);
        if (resetSuccessful) {
            redirectAttributes.addFlashAttribute("message", "Your password has been reset successfully.");
        } else {
            redirectAttributes.addFlashAttribute("error", "Failed to reset password.");
        }
        return "redirect:/login";
    }
}
