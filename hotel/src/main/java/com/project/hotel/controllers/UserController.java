package com.project.hotel.controllers;

import com.project.hotel.interfaces.RoleRepository;
import com.project.hotel.models.Product;
import com.project.hotel.models.Role;
import com.project.hotel.models.User;
import com.project.hotel.services.ProductService;
import com.project.hotel.services.UserService;
import com.project.hotel.util.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = { "http://localhost:3000" })
public class UserController {

    private UserService service;

    private RoleRepository roleRepository;

    private ProductService productService;

    private JwtUtil jwtUtil;

    private AuthenticationManager authenticationManager;

    @GetMapping("/users")
    public Iterable<User> viewUserPage () {
        return service.findAll();
    }

    @PostMapping("/users")
    public User saveUser(@RequestBody User user) {
        return service.save(user);

    }
    @PostMapping("/product")
    public  void  addProduct(@RequestBody Product product){
        productService.save(product);
    }

    @GetMapping("/users/edit/{id}")
    public ModelAndView editUser(@PathVariable(name = "id") Long id) {
        Optional<User> user = service.findById(id);
        ModelAndView mav = new ModelAndView("user_form");
        mav.addObject("user", user);

        List<Role> roles = (List<Role>) roleRepository.findAll();

        mav.addObject("allRoles", roles);

        return mav;
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