import com.esoft.mybatis.d.StudentMapper;
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
public class StudentTest {

    @Test
    public void selectStudent() {
        SqlSession session = SqlSessionFactoryUtil.getSqlSession();
        StudentMapper sm = session.getMapper(StudentMapper.class);
        List<Student> list = sm.selectStudent();
        //session.selectList("com.esoft.mybatis.m.mapper.StudentMapper.selectStudent");
        for (Student s : list) {
            System.out.println(s);
        }

        session.commit();
        session.close();
    }


    @Test
    public void selectStudentById() {
        SqlSession session = SqlSessionFactoryUtil.getSqlSession();
        StudentMapper sm = session.getMapper(StudentMapper.class);
        Student s = sm.selectStudentById(1);

        System.out.println(s);


        session.commit();
        session.close();
    }


}
