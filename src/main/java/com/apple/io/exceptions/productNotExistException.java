package com.apple.io.exceptions;

public class productNotExistException extends IllegalArgumentException {
    public productNotExistException(String msg) {
        super(msg);
    }
}
