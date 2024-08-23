package com.example.restaurant_crud.service;

import com.example.restaurant_crud.dto.ProductDto;
import com.example.restaurant_crud.model.Product;
import com.example.restaurant_crud.model.Restaurant;
import com.example.restaurant_crud.repository.ProductRepository;
import com.example.restaurant_crud.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    private RestaurantRepository restaurantRepository;

    public List<Product> listProducts() {
        return productRepository.findAll();
    }

    public ResponseEntity<Product> findProductById(Long id) {
        Optional<Product> optionalProduct=productRepository.findById(id);
        if (optionalProduct.isPresent()){
            return new ResponseEntity<>(optionalProduct.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Product> addProduct(Product product) {
        productRepository.save(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<Product> updateProduct(Long id, Product newProduct) {
        Optional<Product> oldProduct = productRepository.findById(id);
        if (oldProduct.isPresent()) {
            Product updatedProduct = oldProduct.get();
            updatedProduct.setProductName(newProduct.productName());
            updatedProduct.setProductPrice(newProduct.productPrice());

            Product product=productRepository.save(updatedProduct);
            return new ResponseEntity<>(product,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    public ResponseEntity<HttpStatus> deleteProduct(Long id) {
        productRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
