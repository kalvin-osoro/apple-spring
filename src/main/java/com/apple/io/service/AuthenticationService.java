package com.apple.io.service;

import com.apple.io.exceptions.AuthenticationFailException;
import com.apple.io.model.AuthenticationToken;
import com.apple.io.model.User;

public interface AuthenticationService {

    void saveConfirmationToken(AuthenticationToken authenticationToken);

    AuthenticationToken getToken(User user);

    void authenticate(String token) throws AuthenticationFailException;

    User getUser(String token);
}
