package com.acme.imitate_springaop.easy_version;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class TargetInterceptor implements MethodInterceptor {
 
    /**
     * 重写方法拦截在方法前和方法后加入业务
     * Object obj为目标对象
     * Method method为目标方法
     * Object[] params 为参数，
     * MethodProxy proxy CGlib方法代理对象
     */
    private Advicer advicer;
    public TargetInterceptor(Advicer advicer){
        this.advicer = advicer;
    }
    @Override
    public Object intercept(Object obj, Method method, Object[] params,
                            MethodProxy proxy) throws Throwable {

        advicer.invocateBefore();
        Object result = proxy.invokeSuper(obj, params);
        advicer.invocateAfter();
        return result;
    }
 
 
}