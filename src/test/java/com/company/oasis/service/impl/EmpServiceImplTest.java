package com.company.oasis.service.impl;

import com.company.oasis.dao.pojo.Emp;
import com.company.oasis.service.iservice.EmpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class EmpServiceImplTest {
    @Autowired
    EmpService empService;
    @Test
    public void save() {
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void findByPage() {
        List<Emp> emps = empService.findByPage(2,3);
            for(Emp emp:emps){
                System.err.println(emp);
            }
    }

    @Test
    public void findByName() {
        System.err.println(empService.findByName("a"));
    }

    @Test
    public void findById() {
        System.err.println(empService.findById(1003));
    }
}