package org.hoaithanh.student_management.controller;

import org.hoaithanh.student_management.entity.Cart;
import org.hoaithanh.student_management.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

// CartController.java
@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping
    public String viewCart(Model model) {
        Cart cart = cartService.getCart(1L);
        model.addAttribute("cartItems", cart.getItems());
        model.addAttribute("totalPrice", cart.getTotalPrice());
        return "view-cart";
    }

    @PostMapping("/add/{id}")
    public String addItemToCart(@PathVariable Long id) {
        cartService.addItemToCart(1L, id, 1);
        return "redirect:/cart?userId=" + 1L;
    }

    @GetMapping("/remove/{productId}")
    public String removeItem(@PathVariable Long productId) {
        cartService.removeItemFromCart(1L, productId);
        return "redirect:/cart?userId=" + 1L;
    }


    @PostMapping("/update/{productId}")
    public String updateCart(@PathVariable Long productId, @RequestParam int quantity) {
        cartService.updateCart(1L, productId, quantity);
        return "redirect:/cart?userId=" + 1L;
    }
}
