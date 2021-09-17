package com.example.demo.httpServlet.userDAO;

/**
 * @author dmifed
 */
public class User {
    private static int ids = 0;
    private int id;
    private String name;
    private int age;

    public User(String name, int age) {
        this.id = ++ids;
        this.name = name;
        this.age = age;
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
}
