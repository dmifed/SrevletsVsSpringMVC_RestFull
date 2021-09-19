package com.example.demo.httpServlet.userDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dmifed
 */
public class User {
    private static int ids = 0;
    private int id;
    private String name;
    private int age;
    private List<Transaction> transactions;

    public User(String name, int age) {
        this.id = ++ids;
        this.name = name;
        this.age = age;
        this.transactions = new ArrayList<>();
    }

    public User(String name) {
        this.id = ++ids;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void addTransaction(Transaction transaction){
        transactions.add(transaction);
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public String toJSON() {
        if(age > 0){
            return "{\n" +
                    "  \"id\":" + id + ",\n" +
                    "  \"name\":" + name + ",\n" +
                    "  \"age\":" + age + ",\n" +
                    "}";
        }
        return "{\n" +
                "  \"id\":" + id + ",\n" +
                "  \"name\":" + name + ",\n" +
                "}";
    }

    @Override
    public String toString() {
        if(age !=0 ){
            return "#" + id + " " + " " + name;
        }
        return "#" + id + " " + " " + name + ", " + age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return id == user.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
