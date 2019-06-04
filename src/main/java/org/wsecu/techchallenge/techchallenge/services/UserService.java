package org.wsecu.techchallenge.techchallenge.services;

import org.wsecu.techchallenge.techchallenge.domain.User;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();
    User findUserByUsername(String username);
    User createUser(User user);
    User updateUser(User user);
    void deleteUser(String username);
}
