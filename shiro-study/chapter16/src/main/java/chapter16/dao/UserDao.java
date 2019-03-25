package chapter16.dao;

import chapter16.entity.User;

import java.util.List;

/**
 * chapter16.dao.shiro-study
 * lz 创建于 2017/3/23。
 * 李哲 邮件：QUERYBYLJS@163.com
 * 描述：
 */
public interface UserDao {

    /**
     * 创建
     *
     * @param user
     * @return
     */
    public User createUser(User user);

    /**
     * 修改
     *
     * @param user
     * @return
     */
    public User updateUser(User user);

    /**
     * 删除
     * @param userId
     */
    public void deleteUser(Long userId);

    /**
     * 查找
     * @param userId
     * @return
     */
    public User findOne(Long userId);

    /**
     * 查询所有
     * @return
     */
    public List<User> findAll();

    /**
     * 根据名称查询
     * @param username
     * @return
     */
    public User findByUsername(String username);
}
