package com.atguigu.atcrowdfunding.service;

import com.atguigu.atcrowdfunding.bean.User;

import java.util.Map;

public interface UserService {
    User queryUserlogin(Map<String, Object> paramMap);
}
