
package com.example.travelbackend.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.travelbackend.service.UserService;
import com.example.travelbackend.model.User;
import com.example.travelbackend.security.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.Map;
import java.util.HashMap;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired private UserService userService;
    @Autowired private PasswordEncoder passwordEncoder;
    @Autowired private JwtUtil jwtUtil;

    @PostMapping("/register")
    public Map<String,Object> register(@RequestBody Map<String,String> body){
        String username = body.get("username"), password = body.get("password");
        if(username==null||password==null) throw new RuntimeException("username/password required");
        if(userService.findByUsername(username).isPresent()) throw new RuntimeException("user exists");
        User u = new User(username, passwordEncoder.encode(password), "USER");
        userService.save(u);
        String token = jwtUtil.generateToken(u.getUsername(), u.getRole());
        Map<String,Object> res = new HashMap<>(); res.put("token", token); res.put("username", u.getUsername());
        return res;
    }

    @PostMapping("/login")
    public Map<String,Object> login(@RequestBody Map<String,String> body){
        String username = body.get("username"), password = body.get("password");
        Optional<User> ou = userService.findByUsername(username);
        if(ou.isEmpty()) throw new RuntimeException("invalid credentials");
        User u = ou.get();
        if(!passwordEncoder.matches(password, u.getPassword())) throw new RuntimeException("invalid credentials");
        String token = jwtUtil.generateToken(u.getUsername(), u.getRole());
        Map<String,Object> res = new HashMap<>(); res.put("token", token); res.put("username", u.getUsername());
        return res;
    }
}
