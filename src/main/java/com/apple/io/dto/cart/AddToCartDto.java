package com.apple.io.dto.cart;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@RequiredArgsConstructor
@Getter
@Setter
public class AddToCartDto {
    private Long id;
    private @NotNull Long productId;
    private @NotNull Long quantity;

}
