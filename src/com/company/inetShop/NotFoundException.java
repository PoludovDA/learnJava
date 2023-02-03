package com.company.inetShop;

public class NotFoundException extends Exception {
    private String searchValue;
    private String message;

    public NotFoundException(String message, String searchValue) {
        super(message + searchValue);
    }
}
