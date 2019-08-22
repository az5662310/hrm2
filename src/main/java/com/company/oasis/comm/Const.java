package com.company.oasis.comm;

public class Const {
    public static final String CURRENT_USER = "currentUser";
//注册时用来检验用户名或者email是否有效的类型
    public interface  ValidType{
        String EMAIl="email";
        String USERNAME="username";
    }
    //通过定义内部接口的方式，将静态常量根据功能分组
    public interface  Role{
        int  ROLE_USER=0;//用户权限
        int ROLE_ADMIN=1;//管理员权限
    }
}
