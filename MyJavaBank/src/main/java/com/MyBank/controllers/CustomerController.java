package com.MyBank.controllers;

import com.MyBank.models.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")    //http://localhost:8080/JavaBank/
public class CustomerController {

    private List<Customer> customers = new ArrayList<>();  //criar uma lista para armazenar os customers

    //pagina inicial
    @GetMapping
    public String showCustomersList(Model model) {
        model.addAttribute("customers", customers);
        return "customerList";
    }


    @GetMapping("formulario")  //http://localhost:8080/JavaBank/formulario
    public String showForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "addNew";    //retorna a pagina addNew.html
    }


    // Processa o formulário e adiciona o cliente à lista
    @PostMapping("/addNew")
    public String addNew(@ModelAttribute("customer") Customer customer) {
        customers.add(customer);  //adiciona o cliente a lista
        return "redirect:/";  //Redireciona para customerList.html
    }
}
