package com.lz.springboot.shiro.jwt.springbootshirojwt.repository;

import com.lz.springboot.shiro.jwt.springbootshirojwt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ClassName: UserRepository
 * Description:
 * Date: 2019/4/15 11:44
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * 通过用户名称获取数据
     *
     * @param username
     * @return
     */
    User getUserByUsername(String username);
}
