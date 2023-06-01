package com.apple.io.controller;

import com.apple.io.dto.ResponseDto;
import com.apple.io.dto.user.SigninDto;
import com.apple.io.dto.user.SigninResponseDto;
import com.apple.io.dto.user.SignupDto;
import com.apple.io.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("user")
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UserController {


   private final UserServiceImpl userService;

    //signup
    @PostMapping("/signup")
    public ResponseDto signup(@RequestBody SignupDto signupDto) {
        return userService.signup(signupDto);
    }
    //signin
    @PostMapping("/signin")
    SigninResponseDto signin(@RequestBody SigninDto signinDto) {
        return userService.signin(signinDto);
    }
}
