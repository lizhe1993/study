package chapter10.session.dao;

import chapter10.JdbcTemplateUtils;
import chapter10.SerializableUtils;
import com.sun.org.apache.xerces.internal.impl.dv.ValidatedInfo;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.ValidatingSession;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lz on 2017/3/20.
 */
public class MySessionDao extends CachingSessionDAO {

    private JdbcTemplate jdbcTemplate = JdbcTemplateUtils.jdbcTemplate();

    protected Serializable doCreate(Session session) {
        Serializable sessionId = generateSessionId(session);
        assignSessionId(session,sessionId);
        String sql = "insert into sessions(id,session) values(?,?)";
        jdbcTemplate.update(sql,sessionId, SerializableUtils.serialize(session));
        return sessionId;
    }

    protected void doUpdate(Session session) {
        if(session instanceof ValidatingSession && !((ValidatingSession)session).isValid()){
            return ;
        }
        String sql="update sessions set session=? where id=?";
        jdbcTemplate.update(sql,SerializableUtils.serialize(session),session.getId());
    }

    protected void doDelete(Session session) {
        String sql = "delete from sessions where id=?";
        jdbcTemplate.update(sql,session.getId());
    }

    protected Session doReadSession(Serializable sessionId) {
        String sql  ="select session from sessions where id=?";
        List<String> sessionStrList = jdbcTemplate.queryForList(sql,String.class,sessionId);
        if(sessionStrList.size()==0){
            return null;
        }
        return SerializableUtils.deserialize(sessionStrList.get(0));
    }




}
