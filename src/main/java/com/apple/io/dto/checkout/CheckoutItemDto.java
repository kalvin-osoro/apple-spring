package com.apple.io.dto.checkout;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class CheckoutItemDto {
    private String productName;
    private int quantity;
    private double price;
    private long productId;
    private long userId;
}
