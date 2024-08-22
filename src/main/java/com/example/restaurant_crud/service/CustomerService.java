package com.example.restaurant_crud.service;

import com.example.restaurant_crud.model.Customer;
import com.example.restaurant_crud.repository.CustomerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> listCustomer(){
        return customerRepository.findAll();
    }

    public Optional<Customer> findCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public ResponseEntity<Customer> updateCustomer(Long id, Customer customer) {
        Optional<Customer> optionalCustomer=customerRepository.findById(id);

        if (optionalCustomer==null){
            return ResponseEntity.notFound().build();
        }

        Customer customer1 = optionalCustomer.get();
        BeanUtils.copyProperties(customer,customer1,"id");

        customer1=customerRepository.save(customer1);

        return ResponseEntity.ok(customer1);

    }

    public ResponseEntity<Void> deleteCustomer(Long id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);

        if (optionalCustomer.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Customer customer = optionalCustomer.get();
        customerRepository.delete(customer);

        return ResponseEntity.noContent().build();
    }



}
