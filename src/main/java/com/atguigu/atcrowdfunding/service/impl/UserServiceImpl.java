package com.atguigu.atcrowdfunding.service.impl;

import com.atguigu.atcrowdfunding.Exception.LoginFailException;
import com.atguigu.atcrowdfunding.bean.User;
import com.atguigu.atcrowdfunding.dao.UserMapper;
import com.atguigu.atcrowdfunding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryUserlogin(Map<String, Object> paramMap) {
      User user = userMapper.queryUserlogin(paramMap);
      if (user == null){
          throw new LoginFailException("用户账号或密码不正确");
      }
        return user;
    }
}
