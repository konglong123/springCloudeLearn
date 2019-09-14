package com.kong.demo1.service;

import com.kong.demo1.entity.Student;
import java.util.List;
import java.util.Map;

/**
 * @program: homework
 * @description:
 * @author: Mr.Kong
 * @create: 2019-05-24 11:27
 **/
public interface StudentService {
    List<Student> getAllStudents();
    List<Student> getStudentsByCondition(Map<String,String > pInfo);
    void addStudent(Map<String ,String > pInfo);
}
