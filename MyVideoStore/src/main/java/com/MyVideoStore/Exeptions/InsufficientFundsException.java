package com.MyVideoStore.Exeptions;

import com.MyVideoStore.error.ErrorMessage;

public class InsufficientFundsException extends Exception {

    public InsufficientFundsException(String message) {
        super(ErrorMessage.InsufficientMoneyExeption);
    }
}
