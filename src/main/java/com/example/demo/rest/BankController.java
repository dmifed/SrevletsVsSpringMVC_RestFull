package com.example.demo.rest;

import com.example.demo.httpServlet.userDAO.Transaction;
import com.example.demo.httpServlet.userDAO.TransactionDAO;
import com.example.demo.httpServlet.userDAO.User;
import com.example.demo.httpServlet.userDAO.UserDAO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BankController {
    @GetMapping("/transactions/{userId}")
    public List<Transaction> getTransactions(@PathVariable String userId){
        System.out.println(userId);
        System.out.println(UserDAO.getUsers());
        return TransactionDAO.getTransactions(UserDAO.getUser(Integer.parseInt(userId)));

    }
}
