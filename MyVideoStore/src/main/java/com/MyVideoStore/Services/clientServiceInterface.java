package com.MyVideoStore.Services;

import com.MyVideoStore.models.Customer;

import java.util.List;

public interface clientServiceInterface {

    Customer get(int id);

    Customer create(Customer customer);

    List<Customer> listAllCustomers();

    boolean existByUserName(String username);
}
