package com.kong.demo1.service.impl;

import com.kong.demo1.dao.StudentDao;
import com.kong.demo1.service.StudentService;
import com.kong.demo1.entity.Student;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @program: demo1
 * @description:
 * @author: Mr.Kong
 * @create: 2019-09-09 13:00
 **/
@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDao studentMapper;

    @Override
    public List<Student> getAllStudents() {
        List<Student> students=studentMapper.getAllStudents();
        return students;
    }

    @Override
    public List<Student> getStudentsByCondition(Map<String, String> pInfo) {
        return null;
    }

    @Override
    public void addStudent(Map<String, String> pInfo) {

    }
}
