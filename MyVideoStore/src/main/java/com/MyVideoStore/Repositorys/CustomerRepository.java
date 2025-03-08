package com.MyVideoStore.Repositorys;

import com.MyVideoStore.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Customer findByUserName(String userName);

    boolean existsByUserName(String userName);
}