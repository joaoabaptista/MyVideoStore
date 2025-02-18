package com.MyBank.Exeptions;

import com.MyBank.error.ErrorMessage;

public class InvalidAmountException extends RuntimeException {

    public InvalidAmountException(String message) {
        super(ErrorMessage.InvalidAmountExeption);
    }
}
