package com.apple.io.service.impl;

import com.apple.io.dto.cart.AddToCartDto;
import com.apple.io.dto.cart.CartDto;
import com.apple.io.dto.cart.CartItemDto;
import com.apple.io.exceptions.CustomException;
import com.apple.io.model.Cart;
import com.apple.io.model.Product;
import com.apple.io.model.User;
import com.apple.io.repository.CartRepository;
import com.apple.io.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final   ProductServiceImpl productService;

     private final CartRepository cartRepository;

    @Override
    public void addToCart(AddToCartDto addToCartDto, User user) {

        //validate if the product id is valid
       Product product =   productService.findById(addToCartDto.getProductId());

        Cart cart = new Cart();
        cart.setProduct(product);
        cart.setUser(user);
        cart.setQuantity(Math.toIntExact(addToCartDto.getQuantity()));
        cart.setCreatedDate(new Date());

        //save the cart
        cartRepository.save(cart);
    }

    @Override
    public CartDto listCartItems(User user) {
      List<Cart> cartList = cartRepository.findAllByUserOrderByCreatedDateDesc(user);

      //change cart into cartItemDto
      List<CartItemDto> cartItems = new ArrayList<>();
      double totalCost =0;
      for (Cart cart: cartList) {
          CartItemDto cartItemDto = new CartItemDto(cart);
          totalCost += cartItemDto.getQuantity() * cart.getProduct().getPrice();
          cartItems.add(cartItemDto);
      }
      CartDto cartDto = new CartDto();
      cartDto.setTotalCost(totalCost);
      cartDto.setCartItems(cartItems);
      return cartDto;

    }

    @Override
    public void deleteCartItem(Long cartItemId, User user) {
        //the item id belongs to user
        Optional<Cart> optionalCart = cartRepository.findById(cartItemId);
        if (optionalCart.isEmpty()) {
            throw new  CustomException("cart item is invalid: " + cartItemId);
        }
        Cart cart = optionalCart.get();

        if (cart.getUser() !=user) {
            throw new CustomException("cart item does not belong to user: " + cartItemId);
        }
        cartRepository.delete(cart);
    }
}
