package com.company.oasis.action;

import com.company.oasis.comm.Const;
import com.company.oasis.comm.ResponseResult;
import com.company.oasis.comm.Result;

import com.company.oasis.dao.pojo.User;
import com.company.oasis.service.iservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user/")
public class UserAction {
    @Autowired
    UserService userService;

    /*@RequestMapping("userExist.do")
    @ResponseBody
    public String userExist(@RequestParam String username){
        String msg =userService.userExist(username);
        return  msg;

    }
    @RequestMapping("registry.do")
    @ResponseBody
    public String registry(String  username ,String pwd1 ,String pwd2){
        String msg = Result.ERROR;
        if(pwd1.equals(pwd2)){
            User user =new User( username , pwd1);
            msg=userService.registry(user);
        }
   return  msg;
    }
    @RequestMapping("login.do")
    @ResponseBody
    public String  login(User user ){
        User result  = userService.login(user);

        return  result!=null?Result.SUCCESS:Result.ERROR;
    }*/
    @RequestMapping(value = "login.do", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult<User> login(String username, String password, HttpSession session) {
        ResponseResult<User> result = userService.login(username, password);
        if (result.isSuccess()) {
            session.setAttribute(Const.CURRENT_USER, result.getData());
        }
        return result;
    }

    @RequestMapping(value = "logout.do", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult<String> logout(HttpSession session) {
        session.removeAttribute(Const.CURRENT_USER);
        return ResponseResult.createByError();
    }

    @RequestMapping("check_valid.do")
    @ResponseBody
    public ResponseResult<String> checkValid(String str, String type) {
        return userService.checkValid(str, type);
    }

    @RequestMapping("register.do")
    @ResponseBody
    public ResponseResult<String> register(User user) {
        return userService.register(user);
    }
}
