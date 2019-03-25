import com.esoft.mybatis.d.UserMapper;
import com.esoft.mybatis.m.User;
import com.esoft.mybatis.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * Created by query on 2017/6/27.
 */
public class UserTest {
    private SqlSession session;

    private UserMapper um;

    private void init() {
        this.session = SqlSessionFactoryUtil.getSqlSession();
        this.um = session.getMapper(UserMapper.class);
    }

    private void destroy() {
        this.session.commit();
        this.session.close();
    }

    @Test
    public void saveUser(){
        this.init();
        //业务逻辑
        User user = new User();
        user.setName("lizhe");
        user.setSex("男");
        user.setAge(26);
        um.saveUser(user);
        this.destroy();
    }

    @Test
    public void selectUser(){
        this.init();
        //业务逻辑
        List<User> list = um.selectUser();

        list.forEach(e-> System.out.println(e));

        this.destroy();
    }

    @Test
    public void selectUserById(){
        this.init();
        //业务逻辑
        User user = um.selectUserById(5);
        System.out.println(user);
        this.destroy();
    }
    @Test
    public void updateUser(){
        this.init();
        User user = um.selectUserById(5);
        user.setName("李哲");
        user.setAge(21);
        um.updateUser(user);
        this.destroy();
    }

    @Test
    public void delUser(){
        this.init();
        um.delUser(5);
        this.destroy();
    }
}
