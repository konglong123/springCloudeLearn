package com.kong.demo1.controller;

import com.kong.demo1.entity.Student;
import com.kong.demo1.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @program: homework
 * @description:
 * @author: Mr.Kong
 * @create: 2019-05-24 11:25
 **/
@Controller()
@RequestMapping("/students")
public class StudentController {

    @Resource
    private StudentService studentService;

    //students/find/name/tom,最后代表name入参
    @RequestMapping("/find/name/{name}")
    public String hello(){
        return "show";
    }



    @RequestMapping("/getAllStudents")
    @ResponseBody
    public Map<String ,Object> getAllStudents(){
        List<Student> students=null;
        try{
            students=studentService.getAllStudents();
            System.out.println("查询人数："+students.size());
        }catch (Exception e){
            e.printStackTrace();
        }
        Map<String ,Object> map=new HashMap<>();
        map.put("data",students);
        return map;
    }


}
