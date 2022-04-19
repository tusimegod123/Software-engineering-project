package com.project.softwareengineerinng.controller;


import com.project.softwareengineerinng.model.AuthRequest;
import com.project.softwareengineerinng.model.User;
import com.project.softwareengineerinng.service.UserService;
import com.project.softwareengineerinng.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api")
@CrossOrigin(origins = { "http://localhost:3000" })
public class UserController {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public Iterable<User> viewUserPage () {
        return userService.findAll();

    }
    @GetMapping("/users/{field}")
    public List<User> findBySort(@PathVariable String field) {

        return userService.sortAscending(field);
    }
    @PostMapping("/register")
    public User saveUser(@RequestBody User user) {
        return userService.save(user);

    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("invalid username/password");
        }
        return jwtUtil.generateToken(authRequest.getEmail());
    }
}
