package com.upgrad.imagehoster.service;

import com.upgrad.imagehoster.model.User;
import com.upgrad.imagehoster.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //We are not currently storing the details of the user anywhere
    //We will be storing the user details in the Database & ORMs part
    public void registerUser(User newUser) {
        userRepository.registerUser(newUser);
    }

    //Since we do not have any user in the database, therefore the user with username 'upgrad' and password 'password' is hard-coded
    //This method returns true if the username is 'upgrad' and password is 'password'
    public User login(User user) {
        User existingUser = userRepository.checkUser(user.getUsername(), user.getPassword());
        if (existingUser != null) {
            return existingUser;
        } else {
            return null;
        }
    }

}
