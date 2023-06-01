package com.apple.io.dto.cart;

import com.apple.io.model.Cart;
import com.apple.io.model.Product;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class CartItemDto {
    private Long id;
    private Integer quantity;
    private Product product;

    public CartItemDto(Cart cart) {
        this.id = Long.valueOf(cart.getId());
        this.quantity = cart.getQuantity();
        this.setProduct(cart.getProduct());
    }
}
