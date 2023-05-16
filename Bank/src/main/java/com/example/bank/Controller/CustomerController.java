package com.example.bank.Controller;


import com.example.bank.ApiResponse.ApiResponse;
import com.example.bank.Model.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v3/customer")
public class CustomerController {
  ArrayList<Customer> customers= new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Customer> getCustomer(){
        return customers;

    }
    @PostMapping("/add")
    public String addCustomer(@RequestBody Customer customer){
        customers.add(customer);
        return "Customer Added";
    }
    @PutMapping("/update/{index}")
    public String updateCustomer(@PathVariable int index,@RequestBody Customer customer){
        customers.set(index,customer);
        return "Customer Updated!";
    }
    @DeleteMapping("/delete/{index}")
    public String deleteCustomer(@PathVariable int index){
        customers.remove(index);
        return " Customer Deleted";
    }
    @PutMapping ("/deposit/{index}")
 public ApiResponse depositCustomer(@PathVariable int index,@RequestBody Customer customer ) { // اضافة
 Customer customer1= customers.get(index);
        customer1.setBalance(120);
        customers.set(index,customer1);

        return new ApiResponse("Customer Deposit") ;
    }

    @PutMapping("/withdraw/{index}")
    public ApiResponse withdrawCustomer( @PathVariable int index,@RequestBody Customer customer) { // خصم
        Customer customer1 = customers.get(index);
        if (customer1.getBalance() > 200)
            customer1.setBalance(customer1.getBalance() - 200);
        else
            return new ApiResponse(" no Balance ");


        return null;
    }

    
}
