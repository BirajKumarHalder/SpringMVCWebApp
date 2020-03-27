package com.tutorials.services;

import com.tutorials.models.User;
import com.tutorials.reposetories.AuthRepo;
import com.tutorials.reposetories.UserRepo;

public class UserService {

    public boolean validateCredentials(String userId, String password) {
        AuthRepo authRepo = new AuthRepo();
        return authRepo.validateCredentials(userId, password);
    }

    public User retrieveUserDetails(String userId) {
        UserRepo userRepo = new UserRepo();
        return userRepo.retrieveUserDetails(userId);
    }
}
