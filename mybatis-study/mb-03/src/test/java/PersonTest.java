import com.esoft.mybatis.d.PersonMapper;
import com.esoft.mybatis.d.UserMapper;
import com.esoft.mybatis.m.Person;
import com.esoft.mybatis.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * Created by query on 2017/6/27.
 */
public class PersonTest {

    private SqlSession session;

    private PersonMapper pm;

    private void init() {
        this.session = SqlSessionFactoryUtil.getSqlSession();
        this.pm = session.getMapper(PersonMapper.class);
    }

    private void destroy() {
        this.session.commit();
        this.session.close();
    }


    @Test
    public void selectPersonById(){
        this.init();

        Person p = pm.selectPersonMapper(1);

        System.out.println(p);

        System.out.println(p.getCard());

        this.destroy();
    }
}
