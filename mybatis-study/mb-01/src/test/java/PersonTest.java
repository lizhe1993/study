import com.esoft.mybatis.d.PersonMapper;
import com.esoft.mybatis.m.Person;
import com.esoft.mybatis.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * 类mybaits-study注释说明:
 * <p></p>
 *
 * @author ${user}-QUERYBYLJS@163.com 金鼎科技
 * @version 6.0.0 ${date}
 */
public class PersonTest {

    @Test
    public void selectPersonById(){
        SqlSession session = SqlSessionFactoryUtil.getSqlSession();
        PersonMapper pm = session.getMapper(PersonMapper.class);

        Person p = pm.selectPersonById(1);

        System.out.println(p);
        System.out.println(p.getCard());
        session.commit();
        session.close();



    }
}
