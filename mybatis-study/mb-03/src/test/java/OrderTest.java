import com.esoft.mybatis.d.ClazzMapper;
import com.esoft.mybatis.d.OrderMapper;
import com.esoft.mybatis.m.Order;
import com.esoft.mybatis.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * Created by query on 2017/6/28.
 */
public class OrderTest {

    private SqlSession session;

    private OrderMapper om;

    private void init() {
        this.session = SqlSessionFactoryUtil.getSqlSession();
        this.om = session.getMapper(OrderMapper.class);
    }

    private void destroy() {
        this.session.commit();
        this.session.close();
    }

    @Test
    public void selectById(){
        this.init();

        Order order = om.selectById(1);

        System.out.println(order.getId()+"=="+order.getCode()+"=="+order.getTotal());

        System.out.println(order.getUser());

        order.getArticles().forEach(e-> System.out.println(e));

        this.destroy();
    }

}
