package com.project.hotel.services;

import com.project.hotel.interfaces.ProductRepository;
import com.project.hotel.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> listAllProducts(){
        return  productRepository.findAll();
    }
    public  void save(Product product){
        productRepository.save(product);
    }
    public Optional<Product> findById(Integer id){
        return  productRepository.findById(id);
    }
    public  void deleteById(Integer id){
        productRepository.deleteById(id);
    }
}
