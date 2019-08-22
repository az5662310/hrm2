package com.company.oasis.service.impl;

import com.company.oasis.comm.Const;
import com.company.oasis.comm.ResponseResult;
import com.company.oasis.comm.Result;

import com.company.oasis.dao.UserDao;
import com.company.oasis.dao.pojo.User;
import com.company.oasis.service.iservice.UserService;
import com.company.oasis.util.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    /*  @Override
      public String userExist(String username) {
          int result =userDao.userExist(username);
          return result >0? Result.SUCCESS:Result.ERROR;
      }

      @Override
      public String registry(User user) {
          int result = userDao.insertSelective(user);
          return result >0? Result.SUCCESS:Result.ERROR;
      }

      @Override
      public User login(User user) {
          return userDao.login(user);
      }*/
    public ResponseResult<User> login(String username, String password) {
        //1-验证用户名是否存在，不存在，返回错误信息
        int resultCount = userDao.checkUsername(username);
        if (resultCount == 0) {
            return ResponseResult.createByErrorMessage("用户名已存在");
        }
        //2-对密码进行加密
        String md5Password = MD5Util.MD5EncodeUtf8(password);
        //3-登录验证
        User user = userDao.login(username, md5Password);
        if (user == null) {
            return ResponseResult.createByErrorMessage("密码不正确！");
        }
        return ResponseResult.createBySuccess("登录成功！", user);
    }

    public ResponseResult<String> checkValid(String str, String type) {
        if (StringUtils.isNotBlank(type)) {
            if (Const.ValidType.USERNAME.equals(type)) {
                int resultCount = userDao.checkUsername(str);
                if (resultCount > 0) {
                    return ResponseResult.createByErrorMessage("用户名以存在");
                }
            }
            if (Const.ValidType.EMAIl.equals(type)) {
                int resultCount = userDao.checkEmail(str);
                if (resultCount > 0) {
                    return ResponseResult.createByErrorMessage("email已经存在");
                }
            }
        } else {
            return ResponseResult.createByErrorMessage("参数类型错误，只能选择用户名或email");
        }
        return ResponseResult.createBySuccessMessage("有效！");
    }

    public ResponseResult<String> register(User user) {
        ResponseResult  validResponse = this.checkValid(user.getUsername(), Const.ValidType.USERNAME);
        if (!validResponse.isSuccess()) {
            return validResponse;
        }
        validResponse = this.checkValid(user.getEmail(), Const.ValidType.EMAIl);
        if (!validResponse.isSuccess()) {
            return validResponse;
        }
        user.setRole(Const.Role.ROLE_USER);
        //MD5加密
        user.setPassword(MD5Util.MD5EncodeUtf8(user.getPassword()));
        int resultCount = userDao.insert(user);
        if (resultCount == 0) {
            return ResponseResult.createByErrorMessage("注册失败");
        }
        return ResponseResult.createBySuccessMessage("注册成功");
    }
}
