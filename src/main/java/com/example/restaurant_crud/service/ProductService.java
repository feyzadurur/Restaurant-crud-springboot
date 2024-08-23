package com.example.restaurant_crud.service;

import com.example.restaurant_crud.model.Customer;
import com.example.restaurant_crud.model.Product;
import com.example.restaurant_crud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> listProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> findProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public ResponseEntity<Product> updateProduct(Long id, Product product) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct == null) {
            return ResponseEntity.notFound().build();
        }
        Product product1=optionalProduct.get();
        BeanUtils.copyProperties(product, product1, "id");
        product1 = productRepository.save(product1);
        return ResponseEntity.ok(product1);

    }


    public ResponseEntity<Void> deleteProduct(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct == null) {
            return ResponseEntity.notFound().build();
        }
        Product product1=optionalProduct.get();
        productRepository.delete(product1);
        return ResponseEntity.noContent().build();
    }
}
