import com.esoft.mybatis.m.Article;
import com.esoft.mybatis.m.Order;
import com.esoft.mybatis.m.User;
import com.esoft.mybatis.m.d.OrderMapper;
import com.esoft.mybatis.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * Created by query on 2017/6/26.
 */
public class OrderTest {

    @Test
    public void selectOrderById(){
        SqlSession session = SqlSessionFactoryUtil.getSqlSession();
        OrderMapper om =session.getMapper(OrderMapper.class);
        Order order = om.selectOrderById(2);
        System.out.println(order.getId()+"=="+order.getCode()+"=="+order.getTotal());
        User user = order.getUser();
        System.out.println(user);
        List<Article> articles = order.getArticles();
        for(Article article:articles){
            System.out.println(article);
        }
    }

}
