package com.atguigu.atcrowdfunding.controler;

import com.atguigu.atcrowdfunding.bean.User;
import com.atguigu.atcrowdfunding.service.UserService;
import com.atguigu.atcrowdfunding.util.AjaxResult;
import com.atguigu.atcrowdfunding.util.Const;
import com.atguigu.atcrowdfunding.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@Scope("prototype")
public class DispatcherController {
    @Autowired
    private UserService userService;
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    @RequestMapping("/main")
    public String main(){
        return "main";
    }
    /**
     * 异步提交方式
     */
   //结合Jackson组件，将返回结果转化为字符串，将JSON串以流的格式返回给客户端
    @RequestMapping(value = "/dologin" ,produces="application/json;charset=UTF-8")
    @ResponseBody
    public Object dologin(String loginacct, String userpswd, String type, HttpSession session){
        AjaxResult result = new AjaxResult();

        try {
            Map<String,Object> paramMap = new HashMap<>();
            paramMap.put("loginacct",loginacct);
            paramMap.put("userpswd", MD5Util.digest(userpswd));
            paramMap.put("type",type);
            User user = userService.queryUserlogin(paramMap);
            session.setAttribute(Const.LOGIN_USER,user);
            result.setSuccess(true);
        } catch (Exception e) {
            result.setMessage("登录失败。。。。");
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/index.htm";
    }
    //同步请求方式
   /* @RequestMapping("/dologin")
    public String dologin(String loginacct, String userpswd, String type, HttpSession session){
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("loginacct",loginacct);
        paramMap.put("userpswd",userpswd);
        paramMap.put("type",type);
        User user = userService.queryUserlogin(paramMap);
        session.setAttribute(Const.LOGIN_USER,user);
        return"redirect:/mian.htm";
    }*/
}
