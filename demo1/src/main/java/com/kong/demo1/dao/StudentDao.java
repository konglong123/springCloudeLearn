package com.kong.demo1.dao;
import com.kong.demo1.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

/**
 * @program: homework
 * @description:
 * @author: Mr.Kong
 * @create: 2019-05-24 11:35
 **/
@Repository
public interface StudentDao {

    List<Student> getAllStudents();
    List<Student> getStudentsByCondition(Map<String ,String > pInfo);
    void addStudent(@Param("params") Map<String ,String > pInfo);
}
