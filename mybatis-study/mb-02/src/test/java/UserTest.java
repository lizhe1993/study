import com.esoft.mybatis.m.Order;
import com.esoft.mybatis.m.User;
import com.esoft.mybatis.m.d.UserMapper;
import com.esoft.mybatis.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * Created by query on 2017/6/26.
 */
public class UserTest {
    @Test
    public void selectUserById(){
        SqlSession session = SqlSessionFactoryUtil.getSqlSession();
        UserMapper um = session.getMapper(UserMapper.class);
        User user = um.selectUserById(1);
        System.out.println(user);
        List<Order> orders = user.getOrders();
        for(Order order:orders){
            System.out.println(order);
        }
        session.commit();
        session.close();
    }
}
