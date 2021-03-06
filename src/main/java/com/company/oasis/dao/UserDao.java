package com.company.oasis.dao;

import com.company.oasis.dao.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int checkUsername(String username);
    int checkEmail(String email);

    User login(@Param("username") String username ,@Param("password") String password);
}