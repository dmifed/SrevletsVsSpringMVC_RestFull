package com.example.demo.spring.controller;

import com.example.demo.httpServlet.userDAO.User;
import com.example.demo.httpServlet.userDAO.UserDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author dmifed
 */
@Controller
public class RegistrationController {

    @GetMapping("/register")
    public String registerUser(@RequestParam(required = false) Integer age, @RequestParam String name, Model model){
        User user = new User(name, age);
        UserDAO.saveUser(user);
        UserDAO.printRegistration(user);
        model.addAttribute("user", user);
        return "registration-success";

    }
}
