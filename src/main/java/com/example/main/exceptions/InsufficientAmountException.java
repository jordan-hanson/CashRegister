package com.example.main.exceptions;

public class InsufficientAmountException extends Throwable {
    public InsufficientAmountException(){
        super("Error: There are insufficient amounts you entered in the cash drawer.");
    }
}
