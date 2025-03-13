package com.MyVideoStore.controllers;

import com.MyVideoStore.Services.CustomerService;
import com.MyVideoStore.Services.MovieService;
import com.MyVideoStore.models.Customer;
import com.MyVideoStore.models.Movie;
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
    private final MovieService movieService;

    @Autowired
    public CustomerController(CustomerService customerService, MovieService movieService) {
        this.customerService = customerService;
        this.movieService = movieService;
    }
    
    private Customer loggedInCustomer = null; //Variavel para armazenar um cliente que estaja logado
    
    //pagina inicial catalogo
    @GetMapping
    public String showCatalogo(Model model) {
        List<Movie> movies = movieService.getAllMovies();
        model.addAttribute("movies", movies);
        return "myCatalogo";
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
        public String login(@ModelAttribute("customer") Customer customer, Model model) {
            Customer existingCustomer = customerService.findByUserName(customer.getUserName());

            if (existingCustomer == null || !existingCustomer.getPassword().equals(customer.getPassword())) {
                model.addAttribute("error", "Usuário ou senha inválidos");
                return "login"; // Retorna para a página de login com erro
            }

            loggedInCustomer = existingCustomer; // Define o usuário logado
            return "redirect:/"; // Redireciona para a página inicial
        }
}
