package com.example.intellijexcercise1.Repositories;

import com.example.intellijexcercise1.Entities.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Repo {

    List<Customer> list1 = new ArrayList<Customer>();

    public ArrayList<Customer> initialdata()
    {
        Customer cc,dd;

        cc = new Customer();
        cc.setCname("Joe");
        cc.setCemail("xxx@yahoo.com");

        list1.add(cc);

        return (ArrayList<Customer>) list1;
    }
}
