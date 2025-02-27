package com.MyVideoStore.Exeptions;

import com.MyVideoStore.error.ErrorMessage;

public class InvalidAmountException extends RuntimeException {

    public InvalidAmountException(String message) {
        super(ErrorMessage.InvalidAmountExeption);
    }
}
