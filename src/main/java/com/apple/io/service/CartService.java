package com.apple.io.service;

import com.apple.io.dto.cart.AddToCartDto;
import com.apple.io.dto.cart.CartDto;
import com.apple.io.model.User;
import org.springframework.stereotype.Service;

@Service
public interface CartService {

    void addToCart(AddToCartDto addToCartDto, User user);

    CartDto listCartItems(User user);

    void deleteCartItem(Long itemId, User user);
}
