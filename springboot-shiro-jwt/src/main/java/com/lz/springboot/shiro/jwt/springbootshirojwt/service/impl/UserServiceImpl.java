package com.lz.springboot.shiro.jwt.springbootshirojwt.service.impl;

import com.lz.springboot.shiro.jwt.springbootshirojwt.model.User;
import com.lz.springboot.shiro.jwt.springbootshirojwt.repository.UserRepository;
import com.lz.springboot.shiro.jwt.springbootshirojwt.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName: UserServiceImpl
 * Description:
 * Date: 2019/4/16 11:37
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserByName(String username) {
        if (StringUtils.isBlank(username)) {
            return null;
        }
        User entity = userRepository.getUserByUsername(username);
        return entity;
    }
}
