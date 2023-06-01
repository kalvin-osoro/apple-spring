package com.apple.io.service.impl;

import com.apple.io.exceptions.AuthenticationFailException;
import com.apple.io.model.AuthenticationToken;
import com.apple.io.model.User;
import com.apple.io.repository.TokenRepository;
import com.apple.io.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {


     private final TokenRepository tokenRepository;

    @Override
    public void saveConfirmationToken(AuthenticationToken authenticationToken) {
        tokenRepository.save(authenticationToken);
    }

    @Override
    public AuthenticationToken getToken(User user) {
        return tokenRepository.findByUser(user);
    }

    @Override
    public void authenticate(String token) throws AuthenticationFailException{
        //null check
        if (Objects.isNull(token)) {
            //throw an exception
            throw new AuthenticationFailException("token not present");
        }
        if (Objects.isNull(getUser(token))) {
            throw new AuthenticationFailException("token not valid");
        }

    }

    @Override
    public User getUser(String token) {
        final AuthenticationToken authenticationToken = tokenRepository.findByToken(token);
        if (Objects.isNull(authenticationToken)) {
            return null;
        }
        //authenticationToken is not null
        return authenticationToken.getUser();
    }


}
