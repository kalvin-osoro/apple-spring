package com.apple.io.exceptions;

public class AuthenticationFailException extends IllegalArgumentException {
    public  AuthenticationFailException(String msg) {
        super(msg);
    }

}
