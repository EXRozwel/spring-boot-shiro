package com.example.demo;

import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.CollectionUtils;

import java.util.*;

public class Textutil  {

    private  Map<Object, Object> attributes;
    private String name;
    private PrincipalCollection principalCollection;


    public Map<Object,Object> setAttributes(String name) {
        this.name=name;
        user s= new user();
        s.setName(name);
        String c = "org.apache.shiro.subject.support.DefaultSubjectContext_AUTHENTICATED_SESSION_KEY";
        String d = "org.apache.shiro.subject.support.DefaultSubjectContext_PRINCIPALS_SESSION_KEY";
        Map<Object, Object> attributes = new HashMap();
        if (name.equals("joe.coder") || name.equals("jill.coder")) {
            //attributes.put(c, true);
           // attributes.put(d,name);
            attributes.put(name,"");
        } else {

        }


        return attributes;

    }

    public  Map<Object, Object> getAttributes(){
        this.attributes=setAttributes(name);
        return attributes ;
    }

    public Object getAttribute(Object key) {
        List<Object> a= new ArrayList<Object>();
        Map<Object, Object> attributes = this.getAttributes();
        a.add(attributes.get(key));
        return attributes == null ? null : a;
    }
    public Collection<Object> getAttributeKeys(){
        Map<Object, Object> attributes          =this.getAttributes();
        return attributes == null ? Collections.emptySet() : attributes.keySet();
    }

    public Collection getPrincipal(){


        Set principals = new LinkedHashSet();;
        String S ="hello LinkedHashSet";
        if(principals == null){
            principals.add(S);

        }

        return principals;



    }


    public PrincipalCollection getRunAsPrincipalsStack(){
        List<PrincipalCollection>     principalCollectionList      = (List<PrincipalCollection>) this.getAttribute("org.apache.shiro.subject.support.DefaultSubjectContext_PRINCIPALS_SESSION_KEY");
        return CollectionUtils.isEmpty(principalCollectionList) ? this.principalCollection : (PrincipalCollection) principalCollectionList.get(0);

    }

}
