package Kata.service;


import Kata.models.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();
    void remove(Long id);
    User update(Long id, User newUser);
    User showUser(Long id);
}
