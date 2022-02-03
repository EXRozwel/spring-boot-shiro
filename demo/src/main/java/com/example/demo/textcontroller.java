package com.example.demo;


import org.apache.shiro.SecurityUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class textcontroller {

    @RequestMapping("HL")
    public String hl(HttpServletRequest request) {

                //Subject 是为主体

        // Subject subject = SecurityUtils.getSubject();  //必须创建SecurityManager这里已经创建了只需事先准备realm
        // 这里演示验证主要过程的方法是subject.getPrincipals()和subject.getPrincipal
        // subject.getPrincipals()可以想象成一个集合他迭代一个超对象为subject.getPrlincipal
        // 所谓PrincipalCollection就是session.getAttribute的集合
        //todo 这里根据源码手写出PrincipalCollection来演示运行
        Text   t =  (Text) SecurityUtils.getSubject();







        return null;
    }
}
