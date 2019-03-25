package com.esoft.mybatis.m.d;

import com.esoft.mybatis.m.Employee;

import java.util.HashMap;
import java.util.List;

/**
 * Created by query on 2017/6/26.
 */
public interface EmployeeMapper {

    public List<Employee> selectEmployeeByIdLike(HashMap<String,Object> params);

    public List<Employee> selectEmployByLoginLike(HashMap<String,Object> params);

    public List<Employee> selectEmployeeChoose(HashMap<String,Object> params);

    public List<Employee> selectEmployeeLike(HashMap<String,Object> params);

    public int updateEmployeeIfNecessary(Employee employee);

    public Employee selectEmployeeById(Integer id);

    public List<Employee> selectEmployeeLikeName(Employee employee);

    public List<Employee> selectEmployeeIn(List<Integer> ids);

}
