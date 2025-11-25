
package com.example.travelbackend.service;

import com.example.travelbackend.repository.UserRepository;
import com.example.travelbackend.model.User;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;

@Service
public class UserService {
    @Autowired private UserRepository userRepository;

    public Optional<User> findByUsername(String username){ return userRepository.findByUsername(username); }
    public User save(User u){ return userRepository.save(u); }
}
