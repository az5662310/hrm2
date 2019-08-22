package com.company.oasis.service.impl;

import com.company.oasis.comm.Result;
import com.company.oasis.dao.EmpDao;
import com.company.oasis.dao.pojo.Emp;
import com.company.oasis.service.iservice.EmpService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("empService")
public class EmpServiceImpl implements EmpService {
   @Autowired
   EmpDao empDao;
    @Override
    public String save(Emp emp) {
        int result = empDao.insertSelective(emp);
        return result>0? Result.SUCCESS:Result.ERROR;
    }

    @Override
    public String update(Emp emp) {
        int result = empDao.updateByPrimaryKeySelective(emp);
        return result>0?Result.SUCCESS:Result.ERROR;
    }

    @Override
    public String delete(Integer empno) {
        int result = empDao.deleteByPrimaryKey(empno);
        return result>0?Result.SUCCESS:Result.ERROR;
    }

    @Override
    public List<Emp> findByPage(int page, int size) {
        PageHelper.startPage(page,size);
        return empDao.findAll();
    }

    @Override
    public List<Emp> findByName(String ename) {
        return empDao.findByName(ename);
    }

    @Override
    public Emp findById(int empno) {
        return empDao.selectByPrimaryKey(empno);
    }
}
