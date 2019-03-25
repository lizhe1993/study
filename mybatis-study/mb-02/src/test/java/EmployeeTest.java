import com.esoft.mybatis.m.Employee;
import com.esoft.mybatis.m.d.EmployeeMapper;
import com.esoft.mybatis.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by query on 2017/6/26.
 */
public class EmployeeTest {

    private SqlSession session;

    private EmployeeMapper em;

    private void init() {
        this.session = SqlSessionFactoryUtil.getSqlSession();
        this.em = session.getMapper(EmployeeMapper.class);
    }

    private void destroy() {
        this.session.commit();
        this.session.close();
    }

    @Test
    public void selectEmployeeByIdLike() {
        this.init();
        //业务逻辑
        HashMap<String, Object> params = new HashMap<String, Object>();
        // params.put("id", 1);
        List<Employee> list = em.selectEmployeeByIdLike(params);
        list.forEach(e -> System.out.println(e));

        this.destroy();
    }

    @Test
    public void selectEmployByLoginLike() {
        this.init();
        //业务逻辑
        HashMap<String, Object> params = new HashMap<String, Object>();
        // params.put("username", "jack");
        //params.put("password","123456");
        List<Employee> list = em.selectEmployByLoginLike(params);
        list.forEach(e -> System.out.println(e));
        this.destroy();
    }

    @Test
    public void selectEmployeeChoose() {
        this.init();
        //业务逻辑
        HashMap<String, Object> params = new HashMap<String, Object>();
        //params.put("id",1);
        //params.put("username", "jack");
        //params.put("password", "123456");
        List<Employee> list = em.selectEmployeeChoose(params);
        list.forEach(e -> System.out.println(e));
        this.destroy();
    }

    @Test
    public void selectEmployeeLike() {
        this.init();
        //业务逻辑
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("id", 1);
        params.put("username", "jack");
        params.put("password", "123456");
        List<Employee> list = em.selectEmployeeLike(params);
        list.forEach(e -> System.out.println(e));
        this.destroy();
    }

    @Test
    public void updateEmployeeIfNecessary() {
        this.init();
        //业务逻辑
        Employee employee = em.selectEmployeeById(4);
        employee.setUsername("maray");
        employee.setPassword("123");
        employee.setName("玛丽");
        em.updateEmployeeIfNecessary(employee);

        this.destroy();

    }

    @Test
    public void selectEmployeeLikeName(){
        this.init();
        //业务逻辑
        Employee employee = new Employee();

        employee.setUsername("o");

        List<Employee> list = em.selectEmployeeLikeName(employee);

        System.out.println(list);

        this.destroy();
    }

    @Test
    public void selectEmployeeIn(){
        this.init();
        //业务逻辑
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        List<Employee> list = em.selectEmployeeIn(ids);
        list.forEach(employee -> System.out.println(employee));
        this.destroy();
    }
}
