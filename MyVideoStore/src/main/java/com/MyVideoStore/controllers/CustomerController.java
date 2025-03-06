package com.MyVideoStore.controllers;

import com.MyVideoStore.Services.CustomerService;
import com.MyVideoStore.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")    //http://localhost:8080/VideoStore/
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    
    private Customer loggedInCustomer = null; //Variavel para armazenar um cliente que estaja logado
    
    //pagina inicial catalogo
    @GetMapping
    public String showCatalogo(Model model) {
        return "catalogo";
    }

     @GetMapping("createAccount")  //http://localhost:8080/VideoStore/createAccount
        public String showCreateAccountForm(Model model) {
            model.addAttribute("customer", new Customer());
            return "createAccount";    //retorna a pagina createAccount.html ---->Fazer a pagina createAccount.html
        }

    @PostMapping("/createAccount")
    public String addAccount(@ModelAttribute("customer") Customer customer, Model model) {
        //Verifica se o cliente já existe
        if (customerService.existByUserName(customer.getUserName())) {
            return "createAccount?error";
        }
        customerService.create(customer);
        return "redirect:/";  //Redireciona para customerList.html
    }

    
        @GetMapping("login")  //http://localhost:8080/VideoStore/login
        public String showForm(Model model) {
            model.addAttribute("customer", new Customer());
            return "login";    //retorna a pagina login.html
        }


        // Processa o formulário e adiciona o cliente à lista
        @PostMapping("/login")
        public String addNew(@ModelAttribute("customer") Customer customer) {

            return "redirect:/";  //Redireciona para customerList.html
        }
}
