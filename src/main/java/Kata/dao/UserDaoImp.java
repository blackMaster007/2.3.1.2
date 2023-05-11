package Kata.dao;

import Kata.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User user) {
        this.entityManager.persist(user);
    }

    @Override
    public List<User> listUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void remove(Long id) {
        entityManager.remove(showUser(id));
    }

    @Override
    public User update(Long id, User newUser) {
        User user = showUser(id);
        user.setName(newUser.getName());
        user.setLastName(newUser.getLastName());
        user.setAge(newUser.getAge());
        return user;
    }

    @Override
    public User showUser(Long id) {
        return  entityManager.createQuery("select u from User u where u.id = :id", User.class)
                .setParameter("id", id).getSingleResult();
    }

}
