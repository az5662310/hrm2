package com.company.oasis.action;

import com.company.oasis.comm.Const;
import com.company.oasis.comm.ResponseResult;
import com.company.oasis.dao.pojo.User;
import com.company.oasis.service.iservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/manage/user")
public class UserManageAction {

    @Autowired
    UserService userService;
   @RequestMapping(value = "login.do")
   @ResponseBody
    public ResponseResult<User>  login(String username, String password, HttpSession session){
        ResponseResult<User> response = userService.login(username,password);
        if(response.isSuccess()){
            User user = response.getData();
            if(user.getRole() == Const.Role.ROLE_ADMIN){
                //说明登录的是管理员
                session.setAttribute(Const.CURRENT_USER,user);
                return response;
            }else{
                return ResponseResult.createByErrorMessage("不是管理员,无法登录");
            }
        }
        return response;
    }
    }
