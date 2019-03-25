package chapter16.dao;

import chapter16.entity.Organization;

import java.util.List;

/**
 * chapter16.dao.shiro-study
 * lz 创建于 2017/3/23。
 * 李哲 邮件：QUERYBYLJS@163.com
 * 描述：
 */
public interface OrganizationDao {

    /**
     * 创建组织结构
     * @param organization
     * @return
     */
    public Organization createOrganization(Organization organization);

    /**
     * 修改组织结构
     * @param organization
     * @return
     */
    public Organization updateOrganization(Organization organization);

    /**
     * 删除组织结构
     * @param organizationId
     */
    public void deleteOrganization(Long organizationId);

    /**
     * 根据ID查找组织结构
     * @param organizationId
     * @return
     */
    public Organization findOne(Long organizationId);

    /**
     * 查询所有组织结构
     * @return
     */
    public List<Organization> findAll();

    public List<Organization> findAllWithExclude(Organization excludeOraganization);

    public void move(Organization source,Organization target);
}
