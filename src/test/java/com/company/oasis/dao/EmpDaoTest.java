package com.company.oasis.dao;

import com.company.oasis.dao.pojo.Emp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class EmpDaoTest {
@Autowired
    EmpDao empDao;
    @Test
    public void findAll() {
        for(Emp emp:empDao.findAll()){
            System.err.println(emp);
        }
    }

    @Test
    public void findByName() {
        for(Emp emp:empDao.findByName("a")){
            System.err.println(emp);
        }
    }
}