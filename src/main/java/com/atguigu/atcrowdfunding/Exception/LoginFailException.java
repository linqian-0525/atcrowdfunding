package com.atguigu.atcrowdfunding.Exception;

public class LoginFailException extends RuntimeException{
    public LoginFailException(String message){
        super(message);
    }
}
