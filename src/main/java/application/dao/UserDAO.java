package application.dao;

import application.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@ComponentScan(basePackages = "application/model")
@Transactional
public class UserDAO {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void create(User user) {
        if (user.getId() == null) {
            em.persist(user);
        }
        else {
            em.merge(user);
        }
    }

    @Transactional
    public List<User> findAll() {
        List<User> users = em.createQuery("select u from User u", User.class).getResultList();
        System.out.println("UserDAO:"+users);
        return users;
    }

    @Transactional
    public User findById(long id) {
        return em.find(User.class, id);
    }

    @Transactional
    public void delete(long id) {
        User user = em.find(User.class, id);
        em.remove(user);
    }
}
