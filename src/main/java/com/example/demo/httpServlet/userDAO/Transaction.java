package com.example.demo.httpServlet.userDAO;

import javax.jws.soap.SOAPBinding;

public class Transaction {
    private static int ids = 0;
    private int id;
    private String name = "transaction";
    private User user;

    private void buildTransaction(User user){
        id = ++ids;
        this.user = user;
    }


    public Transaction(User user) {
        buildTransaction(user);
    }

    public Transaction(TransactionDTO transactionDTO){
        String name = transactionDTO.getUserName();
        for(User u : UserDAO.getUsers()){
            if(u.getName().equalsIgnoreCase(name)){
               buildTransaction(u);
            }
        }
        User user = new User(name);
        UserDAO.saveUser(user);
        buildTransaction(user);
    }

    @Override
    public String toString() {
        return "\tT_#" + id + "by " + user;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getName() {
        return name;
    }

}
