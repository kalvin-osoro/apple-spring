package com.apple.io.dto.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class SigninResponseDto {
    private String status;
    private String token;

    public SigninResponseDto(String status, String token) {
        this.status = status;
        this.token = token;
    }
}
