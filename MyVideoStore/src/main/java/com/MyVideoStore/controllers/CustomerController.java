package com.MyVideoStore.controllers;

import com.MyVideoStore.models.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")    //http://localhost:8080/VideoStore/
public class CustomerController {

    private List<Customer> clientes = new ArrayList<>();  //criar uma lista para armazenar os customers
    //(Esta lista pode ser usada para testar a funcionalidade, porem a versão final os clientes e os seus dados devem ser armazenados numa Base de Dados)

    //pagina inicial
    @GetMapping
    public String showCustomersList(Model model) {
//        model.addAttribute("customers", customers);
        return "catalogo";
    }


    @GetMapping("login")  //http://localhost:8080/VideoStore/login
    public String showForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "login";    //retorna a pagina login.html
    }


    // Processa o formulário e adiciona o cliente à lista
    @PostMapping("/login")
    public String addNew(@ModelAttribute("customer") Customer customer) {
        clientes.add(customer);  //adiciona o cliente a lista
        return "redirect:/";  //Redireciona para customerList.html
    }
}
