package com.MyBank.models;


import java.util.HashMap;
import java.util.Map;

public class Customer {

    private int id;
    private static int nextCustomerId = 1;
    private String name;
    private String email;
    private String phoneNumber;
    private Map<Integer, Account> accounts = new HashMap();

    public Customer() {
        id = nextCustomerId++;
    }

    public void addAccount(Account account){
        accounts.put(account.getId(), account);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Map<Integer, Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Map<Integer, Account> accounts) {
        this.accounts = accounts;
    }
}
