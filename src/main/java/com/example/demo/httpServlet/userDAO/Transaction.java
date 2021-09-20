package com.example.demo.httpServlet.userDAO;

public class Transaction {
    private static int ids = 0;
    private int id;
    private String name = "transaction";
    private User user;



    public Transaction(User user) {
        id = ++ids;
        this.user = user;
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
