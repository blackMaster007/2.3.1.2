package Kata.service;

import Kata.dao.UserDao;
import Kata.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UserServiceImp implements UserService {

    private UserDao userDao;

    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }



    @Override
    @Transactional
    public void add(User user) {
        userDao.add(user);
    }


    @Override
    @Transactional(readOnly = true)
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Override
    @Transactional
    public void remove(Long id) {
        userDao.remove(id);
    }

    @Override
    @Transactional
    public User update(Long id, User newUser) {
        return userDao.update(id,newUser);
    }

    @Override
    public User showUser(Long id) {
        return userDao.showUser(id);
    }
}
