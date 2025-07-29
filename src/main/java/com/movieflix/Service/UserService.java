package com.movieflix.Service;

import com.movieflix.Config.SecurityConfig;
import com.movieflix.Controller.AuthController;
import com.movieflix.Entity.User;
import com.movieflix.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.Serial;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
   PasswordEncoder passwordEncoder;
    public User create(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public List<User> list(){
        return userRepository.findAll();
    }
}
