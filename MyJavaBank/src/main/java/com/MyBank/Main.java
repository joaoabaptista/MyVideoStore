package com.MyBank;

import com.MyBank.models.Account;
import com.MyBank.models.Customer;

public class Main {

    public static void main(String[] args) {
        Customer c1 = new Customer();
        c1.setName("John");
        c1.setPhoneNumber("123-456-7890");
        Account a1 = new Account();
        c1.addAccount(a1);
        a1.deposit(100);
        System.out.println(c1.getId()
        + " " + c1.getName()
        + " " + c1.getPhoneNumber()
        + " " + a1.getBalance()
        + " " + a1.getId());

        Customer c2 = new Customer();
        c2.setName("ana");
        c2.setPhoneNumber("999999999");
        Account a2 = new Account();
        c2.addAccount(a2);
        a2.deposit(2200);
        System.out.println(c2.getId()
                + " " + c2.getName()
                + " " + c2.getPhoneNumber()
                + " " + a2.getBalance()
                + " " + a2.getId());



    }
}
