package com.company.oasis.service.iservice;

import com.company.oasis.dao.pojo.Emp;

import java.util.List;

public interface EmpService {
    String save (Emp emp);
    String update (Emp emp);
    String  delete (Integer empno );
    List<Emp> findByPage(int page , int size);
    List<Emp> findByName (String ename);
    Emp findById(int empno);
}
