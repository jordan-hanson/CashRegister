package com.example.main.exceptions;

public class InvalidAmountException extends Exception {
    public InvalidAmountException(int leftOverAmount){
        super("Invalid left over amount: " + leftOverAmount);
    }
}
