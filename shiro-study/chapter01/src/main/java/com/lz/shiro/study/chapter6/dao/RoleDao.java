package com.lz.shiro.study.chapter6.dao;

import com.lz.shiro.study.chapter6.entity.Role;

/**
 * Created by lz on 2017/3/8.
 */
public interface RoleDao {

    public Role createRole(Role role);

    public void deleteRole(Long roleId);

    public void correlationPermissions(Long roleId, Long... permissionIds);

    public void uncorrelationPermissions(Long roleId, Long... permissionIds);

}
