package com.lz.springboot.shiro.jwt.springbootshirojwt.service;

import com.lz.springboot.shiro.jwt.springbootshirojwt.model.User;

/**
 * ClassName: UserService
 * Description:
 * Author: LiZhe lizhej@enn.cn
 * Date: 2019/4/16 11:37
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public interface UserService {

    /**
     * 通过用户名称获取用户实例
     *
     * @param username 用户名称
     * @return 用户实例
     */
    User getUserByName(String username);
}
