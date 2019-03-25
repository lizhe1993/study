package chapter12.service;


import chapter12.entity.Permission;

/**
 * Created by lz on 2017/3/9.
 */
public interface PermissionService {

    public Permission createPermission(Permission permission);

    public void deletePermission(Long permissionId);
}
