package com.limenglei;

//import com.limenglei.bean.Employee;

import com.limenglei.bean.Employee;
import com.limenglei.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Connection;
import java.sql.DriverManager;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot08CacheApplicationTests {

    @Autowired
    EmployeeMapper employeeMapper;

    @Test
    public void contextLoads() {
        System.out.println("你好...");
        Employee emp = employeeMapper.getDeptById(1);
        System.out.println(emp);



    }

}
