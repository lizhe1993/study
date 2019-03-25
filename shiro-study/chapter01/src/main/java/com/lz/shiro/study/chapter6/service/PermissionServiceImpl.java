package com.lz.shiro.study.chapter6.service;

import com.lz.shiro.study.chapter6.dao.PermissionDao;
import com.lz.shiro.study.chapter6.dao.PermissionDaoImpl;
import com.lz.shiro.study.chapter6.entity.Permission;

/**
 * Created by lz on 2017/3/9.
 */
public class PermissionServiceImpl implements  PermissionService {

    private PermissionDao permissionDao = new PermissionDaoImpl();

    public Permission createPermission(Permission permission) {
        return permissionDao.createPermission(permission);
    }

    public void deletePermission(Long permissionId) {
        permissionDao.deletePermission(permissionId);
    }
}
