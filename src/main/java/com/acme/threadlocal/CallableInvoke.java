package com.acme.threadlocal;

import java.lang.reflect.Method;
import java.util.concurrent.Callable;

public class CallableInvoke implements Callable<String> {
    private Object instance;
    private Method method;
    private Object[] args;
    public CallableInvoke(Object instance, Method method,Object...args){
        this.instance = instance;
        this.method = method;
        this.args = args;
    }
    @Override
    public String call() throws Exception {
        Object invoke = method.invoke(instance, args);
        return invoke.toString();
    }
}
