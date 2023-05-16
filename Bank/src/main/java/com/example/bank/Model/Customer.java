package com.example.bank.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Customer {
    private final long id;
    private  String Username;
    private  int balance;

}
