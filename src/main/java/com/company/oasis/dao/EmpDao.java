package com.company.oasis.dao;

import com.company.oasis.dao.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpDao {
    int deleteByPrimaryKey(Integer empno);

    int insert(Emp record);

    int insertSelective(Emp record);

    Emp selectByPrimaryKey(Integer empno);

    int updateByPrimaryKeySelective(Emp record);

    int updateByPrimaryKey(Emp record);

    List<Emp> findAll();

    List<Emp> findByName(@Param("ename") String ename);

}