package chapter12.service;


import chapter12.dao.PermissionDao;
import chapter12.dao.PermissionDaoImpl;
import chapter12.entity.Permission;

/**
 * Created by lz on 2017/3/9.
 */
public class PermissionServiceImpl implements  PermissionService {

    private PermissionDao permissionDao;

    public Permission createPermission(Permission permission) {
        return permissionDao.createPermission(permission);
    }

    public void deletePermission(Long permissionId) {
        permissionDao.deletePermission(permissionId);
    }

    public PermissionDao getPermissionDao() {
        return permissionDao;
    }

    public void setPermissionDao(PermissionDao permissionDao) {
        this.permissionDao = permissionDao;
    }
}
