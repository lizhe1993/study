package com.lz.shiro.study.chapter6.service;

import com.lz.shiro.study.chapter6.dao.RoleDao;
import com.lz.shiro.study.chapter6.dao.RoleDaoImpl;
import com.lz.shiro.study.chapter6.entity.Role;

/**
 * Created by lz on 2017/3/9.
 */
public class RoleServiceImpl implements RoleService {

    private RoleDao roleDao = new RoleDaoImpl();

    public Role createRole(Role role) {
        return roleDao.createRole(role);
    }

    public void deleteRole(Long roleId) {
        roleDao.deleteRole(roleId);
    }

    public void correlationPermissions(Long roleId, Long... permissionIds) {
        roleDao.correlationPermissions(roleId, permissionIds);
    }

    public void uncorrelationPermissions(Long roleId, Long... permissionIds) {
        roleDao.uncorrelationPermissions(roleId, permissionIds);
    }
}
