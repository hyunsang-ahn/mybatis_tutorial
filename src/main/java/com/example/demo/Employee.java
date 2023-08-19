package com.example.demo;


import lombok.Data;

@Data
public class Employee {
    //사실상 엔티티인듯?!

    private int id;
    private int company_id;
    private String name;
    private String address;
}
