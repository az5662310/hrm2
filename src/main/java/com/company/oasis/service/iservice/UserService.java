package com.company.oasis.service.iservice;


import com.company.oasis.comm.ResponseResult;
import com.company.oasis.dao.pojo.User;

public interface UserService {
    ResponseResult<User> login(String username , String password);
    ResponseResult<String> register(User user);
    ResponseResult<String> checkValid(String str, String type);
}
