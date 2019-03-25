import com.esoft.mybatis.d.ClazzMapper;
import com.esoft.mybatis.m.Clazz;
import com.esoft.mybatis.m.Student;
import com.esoft.mybatis.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * 类mybaits-study注释说明:
 * <p></p>
 *
 * @author ${user}-QUERYBYLJS@163.com 金鼎科技
 * @version 6.0.0 ${date}
 */
public class ClazzTest {


    @Test
    public void selectClazz(){
        SqlSession session = SqlSessionFactoryUtil.getSqlSession();
        List<Clazz> list = session.selectList("com.esoft.mybatis.m.mapper.ClazzMapper.selectClazz");

        for(Clazz c:list){
            System.out.println(c);
            /*List<Student> ss = c.getStudents();
            for(Student s:ss){
                System.out.println(s.getId()+" "+s.getName()+" "+s.getSex()+" "+s.getAge());
            }*/
        }

        session.commit();
        session.close();
    }

    @Test
    public void selectClazzById(){

        SqlSession session = SqlSessionFactoryUtil.getSqlSession();
        ClazzMapper cm = session.getMapper(ClazzMapper.class);
        Clazz c = cm.selectClazzById(1);

        System.out.println(c.getId()+" "+c.getCode()+" ");

        List<Student> students = c.getStudents();
        for(Student s:students){
            System.out.println(s);
        }

        session.commit();
        session.close();
    }

}
