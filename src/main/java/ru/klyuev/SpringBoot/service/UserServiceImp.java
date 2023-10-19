package ru.klyuev.SpringBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.klyuev.SpringBoot.dao.UserDAO;
import ru.klyuev.SpringBoot.model.User;


import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImp(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> index() {
        return userDAO.index();
    }

    @Override
    public User show(long id) {
        return userDAO.show(id);
    }

    @Transactional
    @Override
    public void save(User user) {
        userDAO.save(user);
    }

    @Transactional
    @Override
    public void update(long id, User user) {
        userDAO.update(id, user);
    }

    @Transactional
    @Override
    public void delete(long id) {
        userDAO.delete(id);
    }
}
