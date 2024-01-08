package com.example.services;

import com.example.entities.User;
import com.example.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    //private List<User> store =new ArrayList<>();

    /*public UserService()
    {
        store.add(new User(UUID.randomUUID().toString(),"Kaushal Jha", "kj.in"));
        store.add(new User(UUID.randomUUID().toString(),"Puja Jha", "puja.in"));
        store.add(new User(UUID.randomUUID().toString(),"Pretty Jha", "pretty.in"));
        store.add(new User(UUID.randomUUID().toString(),"Asshi Mishri","aashi.in"));
    }*/

    public List<User> getUser()
    {
        return userRepository.findAll();
    }


    public User createUser(User user)
    {
        user.setUserId(UUID.randomUUID().toString());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
