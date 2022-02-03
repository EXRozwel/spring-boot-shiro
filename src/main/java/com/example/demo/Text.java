package com.example.demo;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.SubjectContext;

import java.util.List;
import java.util.Map;

public interface Text extends PrincipalCollection {

    public  PrincipalCollection getPrincipals( List<PrincipalCollection> runAsPrincipals) ;


}
