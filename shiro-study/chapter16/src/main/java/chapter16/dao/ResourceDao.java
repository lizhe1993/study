package chapter16.dao;

import chapter16.entity.Resource;

import java.util.List;

/**
 * chapter16.dao.shiro-study
 * lz 创建于 2017/3/23。
 * 李哲 邮件：QUERYBYLJS@163.com
 * 描述：
 */
public interface ResourceDao {

    /**
     * 创建
     * @param resource
     * @return
     */
    public Resource createResource(Resource resource);

    /**
     * 更新
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
     * 查询一个
     * @param resourceId
     */
    public Resource findOne(Long resourceId);

    /**
     * 查询所有
     * @return
     */
    public List<Resource> findAll();
}
