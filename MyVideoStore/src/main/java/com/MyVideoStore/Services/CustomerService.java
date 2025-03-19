package com.MyVideoStore.Services;

import com.MyVideoStore.models.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements clientServiceInterface {

    private EntityManagerFactory emFactory;

    public void setEmFactory(EntityManagerFactory emFactory) {
        this.emFactory = emFactory;
    }



    @Override
    public Customer get(int id) {
        EntityManager em = emFactory.createEntityManager();

        Customer customer = em.find(Customer.class, id);
        return customer;
    }

    @Override
    public Customer create(Customer customer) {

        EntityManager em = emFactory.createEntityManager();

        try {
            if(!em.getTransaction().isActive()) {
               em.getTransaction().begin();
            }


        }


    }

    @Override
    public List<Customer> listAllCustomers() {
        return List.of();
    }

    @Override
    public boolean existByUserName(String username) {
        return false;
    }
}
