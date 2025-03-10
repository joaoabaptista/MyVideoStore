package com.MyVideoStore.models.Repositorys;

import com.MyVideoStore.models.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
@Primary
public class CustomerRepositoryImplementation implements CustomerRepository {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Override
    public Customer findByUserName(String userName) {
        return null;
    }

    @Override
    public boolean existsByUserName(String userName) {
        return false;
    }

    @PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }






    @Override
    public void flush() {

    }

    @Override
    public <S extends Customer> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Customer> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Customer> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Customer getOne(Integer integer) {
        return null;
    }

    @Override
    public Customer getById(Integer integer) {
        return null;
    }

    @Override
    public Customer getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Customer> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Customer> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Customer> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Customer> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Customer> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Customer> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Customer, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Customer> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Customer> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Customer> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<Customer> findAll() {
        return List.of();
    }

    @Override
    public List<Customer> findAllById(Iterable<Integer> integers) {
        return List.of();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Customer entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Customer> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Customer> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return null;
    }
}
