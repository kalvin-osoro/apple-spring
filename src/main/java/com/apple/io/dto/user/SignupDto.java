package com.apple.io.dto.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Setter
@Getter
//@Entity
public class SignupDto {


    private String firstName;
    private String lastName;
    private String email;
    private String password;

}
