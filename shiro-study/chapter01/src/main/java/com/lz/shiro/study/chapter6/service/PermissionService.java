package com.lz.shiro.study.chapter6.service;

import com.lz.shiro.study.chapter6.entity.Permission;

/**
 * Created by lz on 2017/3/9.
 */
public interface PermissionService {

    public Permission createPermission(Permission permission);

    public void deletePermission(Long permissionId);
}
