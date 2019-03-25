package chapter16.web.taglib;

import chapter16.entity.Organization;
import chapter16.entity.Resource;
import chapter16.entity.Role;
import chapter16.service.OrganizationService;
import chapter16.service.ResourceService;
import chapter16.service.RoleService;
import org.springframework.util.CollectionUtils;
import spring.SpringUtils;

import java.util.Collection;

/**
 * chapter16.web.taglib.shiro-study
 * lz 创建于 2017/3/24。
 * 李哲 邮件：QUERYBYLJS@163.com
 * 描述：
 */
public class Functions {

    private static OrganizationService organizationService;
    private static RoleService roleService;
    private static ResourceService resourceService;

    public static OrganizationService getOrganizationService() {
        if (organizationService == null) {
            organizationService = SpringUtils.getBean(OrganizationService.class);
        }
        return organizationService;
    }

    public static RoleService getRoleService() {
        if (roleService == null) {
            roleService = SpringUtils.getBean(RoleService.class);
        }
        return roleService;
    }

    public static ResourceService getResourceService() {
        if (resourceService == null) {
            resourceService = SpringUtils.getBean(ResourceService.class);
        }
        return resourceService;
    }

    /**
     *  ???
     * @param iterable
     * @param element
     * @return
     */
    public static boolean in(Iterable iterable, Object element) {
        if (iterable == null) {
            return false;
        }
        return CollectionUtils.contains(iterable.iterator(), element);
    }

    /**
     * 获取组织机构名称
     * @param organizationId
     * @return
     */
    public static String organizationName(Long organizationId) {
        Organization organization = getOrganizationService().findOne(organizationId);
        if (organization == null) {
            return "";
        }
        return organization.getName();
    }

    /**
     * 获得多个组织机构名称
     * @param organizationIds
     * @return
     */
    public static String organizationNames(Collection<Long> organizationIds) {
        if (CollectionUtils.isEmpty(organizationIds)) {
            return "";
        }
        StringBuilder s = new StringBuilder();
        for (Long organizationId : organizationIds) {
            Organization organization = getOrganizationService().findOne(organizationId);
            if (organization == null) {
                return "";
            }
            s.append(organization.getName());
            s.append(",");
        }
        if (s.length() > 0) {
            s.deleteCharAt(s.length() - 1);
        }
        return s.toString();
    }

    /**
     * 获取角色名称
     * @param roleId
     * @return
     */
    public static String roleName(Long roleId) {
        Role role = getRoleService().findOne(roleId);
        if (role == null) {
            return "";
        }
        return role.getDescription();
    }

    /**
     * 获取多个角色名称
     * @param roleIds
     * @return
     */
    public static String roleNames(Collection<Long> roleIds) {
        if (CollectionUtils.isEmpty(roleIds)) {
            return "";
        }
        StringBuilder s = new StringBuilder();
        for (Long roleId : roleIds) {
            Role role = getRoleService().findOne(roleId);
            if (role == null) {
                return "";
            }
            s.append(role.getDescription());
            s.append(",");
        }
        if (s.length() > 0) {
            s.deleteCharAt(s.length() - 1);
        }
        return s.toString();
    }

    /**
     * 获取资源名称
     * @param resourceId
     * @return
     */
    public static String resourceName(Long resourceId) {
        Resource resource = getResourceService().findOne(resourceId);
        if(resource == null) {
            return "";
        }
        return resource.getName();
    }

    /**
     * 获取多个资源名称
     * @param resourceIds
     * @return
     */
    public static String resourceNames(Collection<Long> resourceIds) {
        if(CollectionUtils.isEmpty(resourceIds)) {
            return "";
        }

        StringBuilder s = new StringBuilder();
        for(Long resourceId : resourceIds) {
            Resource resource = getResourceService().findOne(resourceId);
            if(resource == null) {
                return "";
            }
            s.append(resource.getName());
            s.append(",");
        }
        if(s.length() > 0) {
            s.deleteCharAt(s.length() - 1);
        }
        return s.toString();
    }

}
