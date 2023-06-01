package com.apple.io.service;

import com.apple.io.dto.ResponseDto;
import com.apple.io.dto.user.SigninDto;
import com.apple.io.dto.user.SigninResponseDto;
import com.apple.io.dto.user.SignupDto;

public interface UserService {
    ResponseDto signup(SignupDto signupDto);


    SigninResponseDto signin(SigninDto signinDto);

}
