package chapter16.dao.impl;

import chapter16.dao.RoleDao;
import chapter16.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * chapter16.dao.impl.shiro-study
 * lz 创建于 2017/3/23。
 * 李哲 邮件：QUERYBYLJS@163.com
 * 描述：
 */
@Repository
public class RoleDaoImpl implements RoleDao {

    @Autowired
    private JdbcTemplate jt;

    public Role createRole(final Role role) {
        final String sql = "insert into sys_role(role, description, resource_ids, available) values(?,?,?,?)";
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jt.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement psst = con.prepareStatement(sql,new String[]{"id"});
                int count = 1;
                psst.setString(count++,role.getRole());
                psst.setString(count++,role.getDescription());
                psst.setString(count++,role.getResourceIdsStr());
                psst.setBoolean(count++,role.getAvailable());
                return psst;
            }
        },keyHolder);
        role.setId(keyHolder.getKey().longValue());
        return role;
    }

    public Role updateRole(Role role) {
        final String sql = "update sys_role set role=?, description=?, resource_ids=?, available=? where id=?";
        jt.update(sql,role.getRole(),role.getDescription(),role.getResourceIdsStr(),role.getAvailable(),role.getId());
        return role;
    }

    public void deleteRole(Long roleId) {
        final String sql = "delete from sys_role where id=?";
        jt.update(sql,roleId);
    }

    public Role findOne(Long roleId) {
        final String sql = "select id, role, description, resource_ids as resourceIdsStr, available from sys_role where id=?";
        List<Role> roleList = jt.query(sql,new BeanPropertyRowMapper<Role>(Role.class),roleId);
        if(roleList.size()==0){
            return null;
        }
        return roleList.get(0);
    }

    public List<Role> findAll() {
        final String sql = "select id, role, description, resource_ids as resourceIdsStr, available from sys_role";
        return jt.query(sql,new BeanPropertyRowMapper<Role>(Role.class));
    }
}
