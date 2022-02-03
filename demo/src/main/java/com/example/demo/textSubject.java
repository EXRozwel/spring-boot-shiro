package com.example.demo;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.AbstractValidatingSessionManager;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.DelegatingSubject;
import org.apache.shiro.util.CollectionUtils;

import java.util.List;
import java.util.Map;

public class textSubject extends SimplePrincipalCollection implements Text {

 @Override
    public PrincipalCollection getPrincipals( List<PrincipalCollection> runAsPrincipals){

     return CollectionUtils.isEmpty(runAsPrincipals) ? (PrincipalCollection) runAsPrincipals : runAsPrincipals.get(0);

 }


}
