package com.example.demo.httpServlet.userDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TransactionDAO {
    private static final Map<User, List<Transaction>> transactions;
    static {
        transactions = new ConcurrentHashMap<>();
        for(User u : UserDAO.getUsers()){
            List<Transaction> transactionsByUser = new ArrayList<>();
            Transaction t1 = new Transaction(u);
            Transaction t2 = new Transaction(u);
            transactionsByUser.add(t1);
            transactionsByUser.add(t2);
            transactions.put(u, transactionsByUser);
        }
    }

    public static List<Transaction> getTransactions(User user) {
        return transactions.get(user);
    }


}
