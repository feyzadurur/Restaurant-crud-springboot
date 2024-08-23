package com.example.restaurant_crud.controller;

import com.example.restaurant_crud.model.Product;
import com.example.restaurant_crud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<Product> list(){
        return productService.listProducts();
    }

    @GetMapping ("{id}")
    public ResponseEntity<Product> findByProductId(@PathVariable Long id) {
        return productService.findProductById(id);
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }
}
