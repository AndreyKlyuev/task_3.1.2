package ru.klyuev.SpringBoot.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.klyuev.SpringBoot.model.User;



import java.util.List;

@Repository
public class UserDAOImp implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> index() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User show(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(long id, User user) {
        User userToBeUpdated = show(id);

        userToBeUpdated.setFirstName(user.getFirstName());
        userToBeUpdated.setLastName(user.getLastName());
        userToBeUpdated.setAge(user.getAge());
        userToBeUpdated.setEmail(user.getEmail());

        entityManager.merge(userToBeUpdated);
        entityManager.flush();
    }

    public void delete(long id) {
        User user = show(id);
        if (null == user) {
            throw new NullPointerException("User not found");
        }
        entityManager.remove(show(id));
        entityManager.flush();
    }
}
