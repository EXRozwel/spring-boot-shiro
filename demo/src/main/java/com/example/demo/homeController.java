package com.example.demo;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SimpleSession;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.apache.shiro.subject.support.DelegatingSubject;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.util.ThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import static com.example.demo.Textutil.*;

@Controller
public class homeController {

@Autowired
private Realm realm;


    @SuppressWarnings("Duplicates")
    @RequestMapping("/")
    public String home( HttpServletRequest request,Model model) {

        String name = "world";                         //Subject 是为主体

        // Subject subject = SecurityUtils.getSubject();  //必须创建SecurityManager这里已经创建了只需事先准备realm
        // 这里演示验证主要过程的方法是subject.getPrincipals()和subject.getPrincipal
        // subject.getPrincipals()可以想象成一个集合他迭代一个超对象为subject.getPrincipal
        // 所谓PrincipalCollection就是session.getAttribute的集合
        //todo 这里根据源码手写出PrincipalCollection来演示运行

        Subject subject = SecurityUtils.getSubject();
        Session subjectSession = subject.getSession();
        Textutil t = new Textutil();
        t.setAttributes("joe.coder");
        Collection objects= t.getAttributeKeys();
                  if(objects != null &&!objects.isEmpty()) {
                      SimplePrincipalCollection simplePrincipalCollection = new SimplePrincipalCollection(objects, realm.getName());

                      subjectSession.setAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY, simplePrincipalCollection);
                     subjectSession.setAttribute(DefaultSubjectContext.AUTHENTICATED_SESSION_KEY,true);
                  }
                PrincipalCollection principalCollection = subject.getPrincipals();
                String s = subjectSession.getAttributeKeys().toString();
                System.out.print(s);
                if (principalCollection != null && !principalCollection.isEmpty()) {
                    Collection<Object> objectCollectio = principalCollection.fromRealm(realm.getName());
                    System.out.print(objectCollectio.toString());

                    System.out.print("已认证");
                    System.out.print(objectCollectio.toString());

                    Collection<Map> principalMaps = subject.getPrincipals().byType(Map.class);
                    if (CollectionUtils.isEmpty(principalMaps)) {
                        name = subject.getPrincipal().toString();
                    }
                    else {
                       name = (String) principalMaps.iterator().next().values().toString();
                         }
    } else {
        name = subject.getSession().toString();
    }

                model.addAttribute("name", name);

                return "hello";


        }

    }

