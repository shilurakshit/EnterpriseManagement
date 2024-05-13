package com.task.service;
//3
import com.task.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private List<User> users = new ArrayList<>();

    // Constructor
    public UserService() {
        users.add(new User(UUID.randomUUID().toString(),"Rakshit", "rakshit@gmail.com"));
        users.add(new User(UUID.randomUUID().toString(),"Raj", "raj@gmail.com"));
        users.add(new User(UUID.randomUUID().toString(),"Harsh", "harsh@gmail.com"));
    }
}
