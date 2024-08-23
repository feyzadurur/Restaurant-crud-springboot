package com.example.restaurant_crud.service;

import com.example.restaurant_crud.model.Customer;
import com.example.restaurant_crud.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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


    public ResponseEntity<Customer> findCustomerById(Long id) {
        Optional<Customer> optionalCustomer= customerRepository.findById(id);
        if (optionalCustomer.isPresent()){
            return new ResponseEntity<>(optionalCustomer.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    public ResponseEntity<Customer> addCustomer(Customer customer) {
        customer=customerRepository.save(customer);
        return new ResponseEntity<>(customer,HttpStatus.OK);
    }


    public ResponseEntity<Customer> updateCustomer(Long id, Customer newCustomer) {
        Optional<Customer> oldCustomer=customerRepository.findById(id);
        if (oldCustomer.isPresent()){
            Customer updatedCustomer = oldCustomer.get();
            updatedCustomer.setName(newCustomer.name());
            updatedCustomer.setPassword(newCustomer.password());

            Customer customer=customerRepository.save(updatedCustomer);
            return new ResponseEntity<>(customer,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<HttpStatus> deleteCustomer(Long id) {
        customerRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
