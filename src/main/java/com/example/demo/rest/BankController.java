package com.example.demo.rest;

import com.example.demo.httpServlet.userDAO.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

@RestController
public class BankController {
    static {
        TransactionDAO.init();
    }
    @GetMapping("/transactions/{userId}")
    public List<Transaction> getTransactions(@PathVariable String userId){
        System.out.println(userId);
        System.out.println(UserDAO.getUsers());
        return TransactionDAO.getTransactions(UserDAO.getUser(Integer.parseInt(userId)));
    }

    @PostMapping("/transactions")
    public Transaction transaction(@RequestBody TransactionDTO transactionDTO){
        //System.out.println("name:" + name);
        //TransactionDTO transactionDTO = new TransactionDTO(name);
        Transaction transaction = new Transaction(transactionDTO);
        TransactionDAO.addTransaction(transaction);
        System.out.println(transaction);
        TransactionDAO.print();
        return transaction;
    }
}
