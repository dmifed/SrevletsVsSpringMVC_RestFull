package com.example.demo.httpServlet.userDAO;

import org.junit.jupiter.api.*;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author dmifed
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TransactionTest{
    Transaction t;
    User u;


    public final User testUser = new User("Mary", 25);

    @BeforeEach
    void setUp() {
        u = new User("Mary", 25);
        t = new Transaction(u);
    }

    @AfterEach
    void tearDown() {

    }

    @Order(2)
    @Test
    void testToString() {
        System.out.println("#2 testToString");
        assertFalse(t.toString().isEmpty());
        assertNotNull(t.toString());
    }

    @Order(Integer.MIN_VALUE)
    @Test
    void getId() {
        System.out.println("#MIN_VALUE getId");
        assertTrue(t.getId() > 0);
    }

    @Test
    void getUser() {
        System.out.println("getUser");
        assertEquals(u.getName(), "Mary");
        assertEquals(u.getAge(), 25);
    }

    @Test
    void getName() {
        System.out.println("getName");
        assertEquals(t.getName(), "transaction");
    }
}