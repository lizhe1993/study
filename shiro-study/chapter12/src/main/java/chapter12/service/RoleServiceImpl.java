package chapter12.service;


import chapter12.dao.RoleDao;
import chapter12.dao.RoleDaoImpl;
import chapter12.entity.Role;

/**
 * Created by lz on 2017/3/9.
 */
public class RoleServiceImpl implements RoleService {

    private RoleDao roleDao;

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

    public RoleDao getRoleDao() {
        return roleDao;
    }

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }
}
