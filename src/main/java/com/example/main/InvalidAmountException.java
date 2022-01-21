package com.example.main;

public class InvalidAmountException extends Exception {
    public InvalidAmountException(int leftOverAmount){
        super("Invalid left over amount for change: " + leftOverAmount);
    }
}
