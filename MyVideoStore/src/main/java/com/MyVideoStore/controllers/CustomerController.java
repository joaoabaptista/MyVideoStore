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

    private List<Customer> clientes = new ArrayList<>();  //criar uma lista para armazenar as contas dos clientes
    //(Esta lista pode ser usada para testar a funcionalidade, porem a versão final os clientes e os seus dados devem ser armazenados numa Base de Dados)
    
    private Customer loggedInCustomer == null  //Variavel para armazenar um cliente que estaja logado
    
    //pagina inicial catalogo
    @GetMapping
    public String showCatalogo(Model model) {
//        model.addAttribute("customers", customers);
        return "catalogo";
    }

     @GetMapping("createAccount")  //http://localhost:8080/VideoStore/createAccount
        public String showCreateAccountForm(Model model) {
            model.addAttribute("customer", new Customer());
            return "createAccount";    //retorna a pagina createAccount.html ---->Fazer a pagina createAccount.html
        }

    @PostMapping("/createAccount")
    public String addAccount(@ModelAttribute("customer") Customer customer) {
        //Verifica se o cliente já existe
        for( Customer c : clientes){
            if(c.getUserName()/*<---Obtém o nome de usuário do cliente existente*/.equals(customer.getUserName())/*<---Obtém o nome de usuário do cliente que está tentando se registrar ou fazer login.*/){
                return "redirect:/createAccount?error"; //caso o cliente ja exista é redirecionado para uma pagina de erro
            }
            clientes.add(customer)
        }
    }
        
        clientes.add(customer);  //adiciona o cliente a lista
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
        clientes.add(customer);  //adiciona o cliente a lista
        return "redirect:/";  //Redireciona para customerList.html
    }
}
