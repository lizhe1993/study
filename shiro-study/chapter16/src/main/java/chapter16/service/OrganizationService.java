package chapter16.service;

import chapter16.entity.Organization;

import java.util.List;

/**
 * chapter16.service.shiro-study
 * lz 创建于 2017/3/23。
 * 李哲 邮件：QUERYBYLJS@163.com
 * 描述：
 */
public interface OrganizationService {
    /**
     * 创建
     * @param organization
     * @return
     */
    public Organization createOrganization(Organization organization);

    /**
     * 修改
     * @param organization
     * @return
     */
    public Organization updateOrganization(Organization organization);

    /**
     * 删除
     * @param organizationId
     */
    public void deleteOrganization(Long organizationId);

    /**
     * 查询单个
     * @param organizationId
     * @return
     */
    Organization findOne(Long organizationId);

    /**
     * 查询多个
     * @return
     */
    List<Organization> findAll();

    Object findAllWithExclude(Organization excludeOraganization);

    void move(Organization source, Organization target);
}
