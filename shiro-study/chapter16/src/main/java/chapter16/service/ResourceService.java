package chapter16.service;

import chapter16.entity.Resource;

import java.util.List;
import java.util.Set;

/**
 * chapter16.service.shiro-study
 * lz 创建于 2017/3/23。
 * 李哲 邮件：QUERYBYLJS@163.com
 * 描述：
 */
public interface ResourceService {
    /**
     * 新建
     * @param resource
     * @return
     */
    public Resource createResource(Resource resource);

    /**
     * 更改
     * @param resource
     * @return
     */
    public Resource updateResource(Resource resource);

    /**
     * 删除
     * @param resourceId
     */
    public void deleteResource(Long resourceId);

    /**
     * 查询
     * @param resourceId
     * @return
     */
    public Resource findOne(Long resourceId);

    /**
     * 查询所有
     * @return
     */
    public List<Resource> findAll();
    /**
     * 得到资源对应的权限字符串
     * @param resourceIds
     * @return
     */
    public Set<String> findPermissions(Set<Long> resourceIds);
    /**
     * 根据用户权限得到菜单
     * @param permissions
     * @return
     */
    public List<Resource> findMenus(Set<String> permissions);
}
