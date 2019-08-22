package com.company.oasis.comm;



import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;
/*
通过设置JsonSerialize对象，
当回传成功状态码，mag和data为null
当回传错误信息（status,msg)时，data为null
使用如下注解,则jackson不对值为null的属性进行包含和处理，key和value在返回值中都不存在
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ResponseResult<T>  implements Serializable {
    private int status;
    private String msg;
    private T data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseResult{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public ResponseResult(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public ResponseResult(int status) {

        this.status = status;
    }

    public ResponseResult(int status, T data) {
        this.status = status;
        this.data = data;
    }

    public ResponseResult(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public ResponseResult() {
    }
@JsonIgnore
    public boolean isSuccess() {
        return this.status == ResponseCode.SUCCESS.getCode();
    }

    public static <T> ResponseResult<T> createBySuccess(){
        return new ResponseResult<T>(ResponseCode.SUCCESS.getCode());
    }

    public static <T> ResponseResult<T> createBySuccessMessage(String msg){
        return new ResponseResult<T>(ResponseCode.SUCCESS.getCode(),msg);
    }

    public static <T> ResponseResult<T> createBySuccess(T data){
        return new ResponseResult<T>(ResponseCode.SUCCESS.getCode(),data);
    }

    public static <T> ResponseResult<T> createBySuccess(String msg,T data){
        return new ResponseResult<T>(ResponseCode.SUCCESS.getCode(),msg,data);
    }


    public static <T> ResponseResult<T> createByError(){
        return new ResponseResult<T>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getDesc());
    }


    public static <T> ResponseResult<T> createByErrorMessage(String errorMessage){
        return new ResponseResult<T>(ResponseCode.ERROR.getCode(),errorMessage);
    }

    public static <T> ResponseResult<T> createByErrorCodeMessage(int errorCode,String errorMessage){
        return new ResponseResult<T>(errorCode,errorMessage);
    }
}