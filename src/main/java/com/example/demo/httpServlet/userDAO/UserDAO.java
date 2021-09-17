package com.example.demo.httpServlet.userDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dmifed
 */
public class UserDAO {
    private static List<User> users;

    static {
        users = new ArrayList<>();
        users.add(new User("Vasya"));
        users.add(new User("Kate", 25));
        users.add(new User("Ivan", 56));

    }

    public static List<User> getUsers() {
        return users;
    }

    public static User getUser(int id){
        if(id < 0 || id >= users.size()) throw new IndexOutOfBoundsException();
        return users.get(id);
    }

    public static void saveUser(User user){
        users.add(user);
    }

    public static void printRegistration(User user){
        System.out.println("user #" + user.getId() + " " + user.getName() + " has been registered");
    }
}
