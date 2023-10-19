package ru.klyuev.SpringBoot.dao;



import ru.klyuev.SpringBoot.model.User;

import java.util.List;

public interface UserDAO {
    List<User> index();
    User show(long id);
    void save(User user);
    void update(long id, User user);

    void delete(long id);
}
