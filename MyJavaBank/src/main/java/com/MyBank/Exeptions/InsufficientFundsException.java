package com.MyBank.Exeptions;

import com.MyBank.error.ErrorMessage;

public class InsufficientFundsException extends Exception {

    public InsufficientFundsException(String message) {
        super(ErrorMessage.InsufficientMoneyExeption);
    }
}
