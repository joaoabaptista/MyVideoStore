package com.MyBank.controllers;

import com.MyBank.models.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/custumer")
public class CustomerController {

    @RequestMapping(method = RequestMethod.GET, path = "/index")
    public String showIndex(Model model) {
        model.addAttribute("customer", new Customer());
        return "index";
    }
}
