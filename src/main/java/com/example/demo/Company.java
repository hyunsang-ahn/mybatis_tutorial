package com.example.demo;


import lombok.Data;

import java.util.List;

@Data
public class Company {
    //사실상 엔티티인듯?!

    private int id;
    private String name;
    private String address;
    private List<Employee> employeeList;
}
