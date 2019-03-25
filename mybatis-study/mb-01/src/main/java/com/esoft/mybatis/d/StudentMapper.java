package com.esoft.mybatis.d;

import com.esoft.mybatis.m.Student;

import java.util.List;

/**
 * 类mybaits-study注释说明:
 * <p></p>
 *
 * @author ${user}-QUERYBYLJS@163.com 金鼎科技
 * @version 6.0.0 ${date}
 */
public interface StudentMapper {

    public Student selectStudentById(Integer id);

    public List<Student> selectStudent();
}
