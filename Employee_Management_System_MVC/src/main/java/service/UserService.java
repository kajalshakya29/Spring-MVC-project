package service;

import dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    public boolean checkLogin(String username, String password) {
        return userDao.validateUser(username, password);
    }
}
