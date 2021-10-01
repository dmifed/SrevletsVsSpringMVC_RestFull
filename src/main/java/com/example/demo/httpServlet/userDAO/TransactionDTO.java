package com.example.demo.httpServlet.userDAO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Created by DIMA, on 01.10.2021
 */
@JsonSerialize
public class TransactionDTO {
    private String userName;

    public TransactionDTO(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public TransactionDTO() {
    }
}
