package com.apple.io.dto.cart;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
public class CartDto {
    private List<CartItemDto> cartItems;
    private double totalCost;

}
