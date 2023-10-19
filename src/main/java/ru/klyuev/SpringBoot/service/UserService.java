package ru.klyuev.SpringBoot.service;



import ru.klyuev.SpringBoot.model.User;

import java.util.List;

public interface UserService {
    List<User> index();
    User show(long id);
    void save(User user);
    void update(long id, User user);

    void delete(long id);
}
