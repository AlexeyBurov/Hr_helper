package com.fortegroup.service.accounts;

import com.fortegroup.dao.accounts.UserDao;
import com.fortegroup.model.accounts.User;
import com.fortegroup.service.accounts.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Base implementation for {@link UserService} interface
 * @author Alexey Burov
 * @version 1.0
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @Transactional
    public User loadUserByUsername(String username) {
        return userDao.loadUserByUsername(username);
    }

    @Override
    @Transactional
    public User loadUserByNameAndPassword(String username, String password){
        User daoUser = userDao.loadUserByUsername(username);
        if(bCryptPasswordEncoder.matches(password,daoUser.getPassword()))
            return daoUser;
        return null;
    }

    @Transactional
    @Override
    public User saveUser(User user) {
        user.setAuthorities("ROLE_USER");
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Long id =  userDao.saveUser(user);
        return get(id);
    }

    @Transactional
    @Override
    public User get(long id) {
        return userDao.get(id);
    }


}
