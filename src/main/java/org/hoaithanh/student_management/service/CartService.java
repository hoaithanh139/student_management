package org.hoaithanh.student_management.service;

import org.springframework.transaction.annotation.Transactional;
import org.hoaithanh.student_management.entity.Cart;
import org.hoaithanh.student_management.entity.CartItem;
import org.hoaithanh.student_management.entity.Product;
import org.hoaithanh.student_management.repository.CartItemRepository;
import org.hoaithanh.student_management.repository.CartRepository;
import org.hoaithanh.student_management.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


// CartService.java
@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ProductRepository productRepository;

    public Cart getCart(Long userId) {
        Cart cart = cartRepository.findByUserId(userId);
        if (cart == null) {
            cart = new Cart();
            cart.setUserId(userId);
            cartRepository.save(cart);
        }
        return cart;
    }


    public void  addItemToCart(Long userId, Long productId, Integer quantity) {
        Cart cart = getCart(userId);
        Optional<Product> product = productRepository.findById(productId);
        if (product.isPresent()) {
            CartItem cartItem = cartItemRepository
                    .findByCartIdAndProductId(cart.getId(), productId)
                    .stream()
                    .findFirst()
                    .orElse(new CartItem());

            cartItem.setCart(cart);
            cartItem.setProduct(product.get());
            //cartItem.setQuantity(quantity);
            cartItem.setQuantity(cartItem.getQuantity() + quantity);
            cartItem.setTotalPrice(cartItem.getProduct().getPrice() * quantity);
            cartItemRepository.save(cartItem);

            updateTotalPrice(cart);
        }
    }

    @Transactional
    public void removeItemFromCart(Long userId, Long productId) {
       Cart cart = cartRepository.findByUserId(userId);
        if (cart == null) {
            throw new RuntimeException("Cart not found for user with ID: " + userId);
        }

        List<CartItem> cartItem = cartItemRepository.findByCartIdAndProductId(cart.getId(), productId);

        if (cart == null) {
            throw new RuntimeException("Cart item not found for product ID: " + productId);
        }
        // Xóa cartItem nếu tồn tại
        cartItemRepository.deleteAll(cartItem);
    }



    public void updateCart(Long userId, Long productId, int quantity) {
        Cart cart = cartRepository.findByUserId(userId);

        if (cart == null) {
            cart = new Cart();
            cart.setUserId(userId);
            cartRepository.save(cart);
        }

        List<CartItem> cartItems = cartItemRepository.findByCartIdAndProductId(cart.getId(), productId);
        CartItem cartItem;

        if (!cartItems.isEmpty()) {
            cartItem = cartItems.get(0);
            cartItem.setQuantity(quantity);
        } else {
            Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
            cartItem = new CartItem();
            cartItem.setCart(cart);
            cartItem.setProduct(product);
            cartItem.setQuantity(quantity);
            cartItem.setTotalPrice(product.getPrice() * quantity);
            cartItemRepository.save(cartItem);
        }

        updateTotalPrice(cart);
    }

    private void updateTotalPrice(Cart cart) {
        double totalPrice = cart.getItems().stream()
                .mapToDouble(CartItem::getTotalPrice)
                .sum();
        cart.setTotalPrice(totalPrice);
        cartRepository.save(cart);
    }
}

