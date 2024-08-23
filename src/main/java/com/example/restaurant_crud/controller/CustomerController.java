package com.example.restaurant_crud.controller;

import com.example.restaurant_crud.model.Customer;
import com.example.restaurant_crud.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/all")
    public List<Customer> list(){
        return customerService.listCustomer();
    }

    @GetMapping("{id}")
    public ResponseEntity<Customer> findByCustomerId(@PathVariable Long id) {
        return customerService.findCustomerById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id,
                                            @RequestBody Customer customer) {
        return customerService.updateCustomer(id, customer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable Long id) {
        return customerService.deleteCustomer(id);
    }



}
