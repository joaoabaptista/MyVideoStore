package com.MyVideoStore.models;

import com.MyVideoStore.Exeptions.InvalidAmountException;
import com.MyVideoStore.Exeptions.InsufficientFundsException;

public class Account{

    private int id;
    private double balance;
    private static int nextAccountId = 1;

    public Account(){
        this.id = nextAccountId++;
        this.balance = 0.0;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) throws InvalidAmountException {
        if(amount <= 0) {
            throw new InvalidAmountException("Deposit amount must be greater than zero.");
        }
        balance += amount;
    }

    public void withdraw(double amount) throws InsufficientFundsException, InvalidAmountException {
        if(amount <= 0) {
            throw new InvalidAmountException("Withdraw amount must be greater than zero.");
        }
        if(balance - amount < 0) {
            throw new InsufficientFundsException("Insufficient funds for the withdrawal.");
        }
        balance -= amount;
    }

}