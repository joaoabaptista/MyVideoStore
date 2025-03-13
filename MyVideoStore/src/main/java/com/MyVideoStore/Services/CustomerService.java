package com.MyVideoStore.Services;

import com.MyVideoStore.models.Repositorys.CustomerRepository;
import com.MyVideoStore.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements clientServiceInterface {

//    private ConnectionManager connectionManager;
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public Customer get(int id) {

        return customerRepository.findById(id).get();//Optional?????
    }


    @Override
    public Customer create(Customer customer) {
        return customerRepository.save(customer);

    }

    @Override
    public List<Customer> listAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public boolean existByUserName(String username) {

        return customerRepository.existsByUserName(username);
    }

    public Customer findByUserName(String userName) {
        return customerRepository.findByUserName(userName);
    }


}
