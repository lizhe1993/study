package chapter12.dao;


import chapter12.entity.Permission;

/**
 * Created by lz on 2017/3/8.
 */
public interface PermissionDao {

    public Permission createPermission(Permission permission);

    public void deletePermission(Long permissionId);
}
