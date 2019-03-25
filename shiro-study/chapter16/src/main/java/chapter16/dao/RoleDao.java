package chapter16.dao;

import chapter16.entity.Role;

import java.util.List;

/**
 * chapter16.dao.shiro-study
 * lz 创建于 2017/3/23。
 * 李哲 邮件：QUERYBYLJS@163.com
 * 描述：
 */
public interface RoleDao {
    /**
     * 创建
     * @param role
     * @return
     */
    public Role createRole(Role role);

    /**
     * 修改
     * @param role
     * @return
     */
    public Role updateRole(Role role);

    /**
     * 删除
     * @param roleId
     */
    public void deleteRole(Long roleId);

    /**
     * 查询单个
     * @param roleId
     * @return
     */
    public Role findOne(Long roleId);

    /**
     * 查询所有
     * @return
     */
    public List<Role> findAll();
}
