package com.MyVideoStore.Services;

import com.MyVideoStore.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class CustomerService implements clientServiceInterface {

    private ConnectionManager connectionManager;

    @Autowired
    public void setConnectionManager(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }


    @Override
    public Customer get(int id) {
        String query = "SELECT * FROM customer WHERE id = ?";

        try (Connection connection = connectionManager.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setUserName(rs.getString("username"));
                customer.setPassword(rs.getString("password"));
                customer.setEmail(rs.getString("email"));
                customer.setPasswordConfirm(rs.getString("passwordConfirm"));
                return customer;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error fetching customer by ID: " + e.getMessage(), e);
        }
        return null;
    }


    @Override
    public Customer create(Customer customer) {

        String query = "INSERT INTO client (userName, password) VALUES (?, ?)";


        try (Connection connection = connectionManager.getConnection();
            PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, customer.getUserName());
            ps.setString(2, customer.getPassword());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if(rs.next()) {
                customer.setId(rs.getInt(1));
            }

            return customer;

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Customer> listAllCustomers() {
        return List.of();
    }

    @Override
    public boolean existByUserName(String username) {

        String query = "SELECT COUNT(*) FROM client WHERE userName = ?";

        try (Connection connection = connectionManager.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, username);

            try(ResultSet rs = ps.executeQuery()) {
                if(rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao verificar existência do usuário: " + e.getMessage(), e);
        }
        return false;
    }


}
