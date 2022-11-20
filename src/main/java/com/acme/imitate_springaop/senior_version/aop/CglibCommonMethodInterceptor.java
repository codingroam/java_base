package com.acme.imitate_springaop.senior_version.aop;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class CglibCommonMethodInterceptor implements MethodInterceptor {

    private List<AspectJMethodInterceptor> AspectJMethodInterceptors = new ArrayList<>();
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if(AspectJMethodInterceptors.size() > 0){
            //AspectJMethodInterceptors.get(0).invoke()
        }
        return null;
    }
}
