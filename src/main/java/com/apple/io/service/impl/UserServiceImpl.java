package com.apple.io.service.impl;

import com.apple.io.dto.ResponseDto;
import com.apple.io.dto.user.SigninDto;
import com.apple.io.dto.user.SigninResponseDto;
import com.apple.io.dto.user.SignupDto;
import com.apple.io.exceptions.AuthenticationFailException;
import com.apple.io.exceptions.CustomException;
import com.apple.io.model.AuthenticationToken;
import com.apple.io.model.User;
import com.apple.io.repository.UserRepository;
import com.apple.io.service.UserService;
import jakarta.transaction.Transactional;
import jakarta.xml.bind.DatatypeConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

     private final AuthenticationServiceImpl authenticationService;

    @Transactional
    @Override
    public ResponseDto signup(SignupDto signupDto) {
        //check if user is already present
        if (Objects.nonNull(userRepository.findByEmail(signupDto.getEmail()))) {
            //we have a user
            throw new CustomException("user already present");
        }

        //hash the password
        String encryptedPassword = signupDto.getPassword();
        try {
            encryptedPassword = hashPassword(signupDto.getPassword());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        //save the user
//        User user = new User(signupDto.getFirstName(), signupDto.getLastName(), signupDto.getEmail(),encryptedPassword);
//        userRepository.save(user);
        User user = new User();
        user.setFirstName(signupDto.getFirstName());
        user.setLastName(signupDto.getLastName());
        user.setEmail(signupDto.getEmail());
        user.setPassword(encryptedPassword);

        userRepository.save(user);

        //create the token
        final AuthenticationToken authenticationToken = new AuthenticationToken(user);
        authenticationService.saveConfirmationToken(authenticationToken);


        ResponseDto responseDto = new ResponseDto("success", "User created successfully");
        return responseDto;
    }



    private String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        String hash = DatatypeConverter
                .printHexBinary(digest).toUpperCase();
        return hash;
    }
    @Override
    public SigninResponseDto signin(SigninDto signinDto) {
        //find user by email
        User user = userRepository.findByEmail(signinDto.getEmail());

        if (Objects.isNull(user)) {
            throw new AuthenticationFailException("User is not valid");
        }

        //hash the password
        try {
            if(!user.getPassword().equals(hashPassword(signinDto.getPassword())) ) {
                throw new AuthenticationFailException("Wrong password");
            }
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        //compare the password in DB

        //if password match
        AuthenticationToken token = authenticationService.getToken(user);
        //retrieve the token
        if (Objects.isNull(token)) {
            throw new CustomException("Token is not present");
        }
        return new SigninResponseDto("Success",token.getToken());
        //return response
    }
}
