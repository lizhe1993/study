import com.esoft.mybatis.d.ClazzMapper;
import com.esoft.mybatis.d.PersonMapper;
import com.esoft.mybatis.m.Clazz;
import com.esoft.mybatis.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * Created by query on 2017/6/27.
 */
public class ClazzTest {
    private SqlSession session;

    private ClazzMapper cm;

    private void init() {
        this.session = SqlSessionFactoryUtil.getSqlSession();
        this.cm = session.getMapper(ClazzMapper.class);
    }

    private void destroy() {
        this.session.commit();
        this.session.close();
    }


    @Test
    public void selectClazzById(){
        this.init();

        Clazz clazz = cm.selectById(1);
        System.out.println(clazz.getId()+"=="+clazz.getCode());

        clazz.getStudents().forEach(e-> System.out.println(e));

        this.destroy();
    }

}
