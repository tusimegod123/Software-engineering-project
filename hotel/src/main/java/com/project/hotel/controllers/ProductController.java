package com.project.hotel.controllers;

import com.project.hotel.models.User;
import com.project.hotel.services.ProductService;
import com.project.hotel.models.Product;
import com.project.hotel.services.UserService;
import com.project.hotel.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;




    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping
    public List<Product> list (){
        return productService.listAllProducts();
    }
    @GetMapping("/{id}")
    public Optional<Product> getProduct(@PathVariable Integer id){
        return productService.findById(id);
    }

    @PostMapping
    public  void  addProduct(@RequestBody Product product){
        productService.save(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable Integer id){
        try {
            Optional<Product> existProduct = productService.findById(id);
            productService.save(product);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NoSuchElementException e){
           return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Integer id ){
        productService.deleteById(id);
    }
    @PostMapping("/authenticate")
    public String generateToken(@RequestBody User user) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("invalid username/password");
        }
        return jwtUtil.generateToken(user.getUsername());
    }

}

