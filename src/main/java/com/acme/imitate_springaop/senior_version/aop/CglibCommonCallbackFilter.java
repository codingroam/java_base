package com.acme.imitate_springaop.senior_version.aop;

import net.sf.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;


public class CglibCommonCallbackFilter implements CallbackFilter {


    private Method method;

    public CglibCommonCallbackFilter(Method method){
        this.method = method;
    }
    @Override
    public int accept(Method method) {
        if(method.getName().equals("method1")){
            System.out.println("filter method1 ==0");
            return 0;
        }
        if(method.getName().equals("method2")){
            System.out.println("filter method2 ==1");
            return 1;
        }
        if(method.getName().equals("method3")){
            System.out.println("filter method3 ==2");
            return 2;
        }
        return 0;
    }

}
