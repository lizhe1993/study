package com.lz.shiro.study.chapter6.service;

import com.lz.shiro.study.chapter6.dao.UserDao;
import com.lz.shiro.study.chapter6.dao.UserDaoImpl;
import com.lz.shiro.study.chapter6.entity.User;

import java.util.Set;

/**
 * Created by lz on 2017/3/10.
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();
    private PasswordHelper passwordHelper = new PasswordHelper();


    public User createUser(User user) {
        passwordHelper.encryptyPassword(user);
        return userDao.createUser(user);
    }

    public void changePassword(Long userId, String newPassword) {
        User user =userDao.findOne(userId);
        user.setPassword(newPassword);
        passwordHelper.encryptyPassword(user);
        userDao.updateUser(user);
    }

    public void correlationRoles(Long userId, Long... roleIds) {
        userDao.correlationRoles(userId, roleIds);
    }

    public void uncorrelationRoles(Long userId, Long... roleIds) {
        userDao.uncorrelationRoles(userId, roleIds);
    }

    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    public Set<String> findRoles(String username) {
        return userDao.findRoles(username);
    }

    public Set<String> findPermissions(String username) {
        return userDao.findPermissions(username);
    }
}
