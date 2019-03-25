import com.esoft.mybatis.m.User;
import com.esoft.mybatis.util.SqlSessionFactoryUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * Created by query on 2017/6/21.
 */
public class UserTest {

    @Test
    public void saveUser() throws IOException {
        //读取配置文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();

        User user = new User();
        user.setName("lizhe");
        user.setAge(26);
        user.setSex("男");

        session.insert("com.esoft.mybatis.m.mapper.UserMapper.save", user);
        session.commit();
        session.close();
    }

    @Test
    public void selectUser(){
        SqlSession session = SqlSessionFactoryUtil.getSqlSession();
        List<Map<String,Object>> result = session.selectList("com.esoft.mybatis.m.mapper.UserMapper.selectUser");
        for(Map map :result){
            System.out.println(map);
        }
        session.commit();
        session.close();
    }

    @Test
    public void selectUserById(){
        SqlSession session = SqlSessionFactoryUtil.getSqlSession();
        User user=session.selectOne("com.esoft.mybatis.m.mapper.UserMapper.selectUserById",2);
        System.out.println(user.toString());
        session.commit();
        session.close();
    }

    @Test
    public void updateUserById(){
        SqlSession session = SqlSessionFactoryUtil.getSqlSession();
        User user = new User();
        user.setId(2);
        user.setName("李小三");
        user.setAge(20);
        user.setSex("女");
        int i = session.update("com.esoft.mybatis.m.mapper.UserMapper.updateUserById",user);
        session.commit();
        session.close();
    }


    @Test
    public void deleteUserById(){
        SqlSession session = SqlSessionFactoryUtil.getSqlSession();
        int i = session.delete("com.esoft.mybatis.m.mapper.UserMapper.deleteUserById",3);
        session.commit();
        session.close();
    }

    @Test
    public void selectUser1(){
        SqlSession session = SqlSessionFactoryUtil.getSqlSession();
        List<User> result = session.selectList("com.esoft.mybatis.m.mapper.UserMapper.selectUser1");
        for(User user :result){
            System.out.println(user.toString());
        }
        session.commit();
        session.close();
    }

}
