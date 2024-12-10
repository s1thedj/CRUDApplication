package application.service;

import application.dao.UserDAO;
import application.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserDAO userDAO;

    @Transactional
    public void create(User user) {
        userDAO.create(user);
    }

    @Transactional
    public List<User> findAll() {
        List<User> users = userDAO.findAll();
        System.out.println(users);
        return users;
    }

    @Transactional
    public User findById(long id) {
        return userDAO.findById(id);
    }

    @Transactional
    public void delete(long id){
        userDAO.delete(id);
    }
}
