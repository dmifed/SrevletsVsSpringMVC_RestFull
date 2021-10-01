package com.example.demo.httpServlet.userDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TransactionDAO {
    private static Map<User, List<Transaction>> transactions;
    public static void init(){
        transactions = new ConcurrentHashMap<>();
        for(User u : UserDAO.getUsers()){
            List<Transaction> transactionsByUser = new ArrayList<>();
            Transaction t1 = new Transaction(u);
            Transaction t2 = new Transaction(u);
            transactionsByUser.add(t1);
            transactionsByUser.add(t2);
            transactions.put(u, transactionsByUser);
        }
        System.out.println(transactions);
    }

    public static List<Transaction> getTransactions(User user) {
        return transactions.get(user);
    }

    public static void addTransaction(Transaction transaction){
        User u = transaction.getUser();
        if(transactions.containsKey(u)){
            List<Transaction> trans = transactions.get(u);
            trans.add(transaction);
        }
        else {
            List<Transaction> list = new ArrayList<>();
            list.add(transaction);
            transactions.put(u, list);
        }

    }
    public static void print(){
        System.out.println(transactions);
    }




}
