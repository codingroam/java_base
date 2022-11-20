package com.acme.imitate_springaop.easy_version;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

import java.lang.reflect.Method;


@Setter
@Getter
public class Advicer {

    private Class aspectClass;
    private Method beforeMethod;
    private Method afterMethod;
    private Object instance;

    public Advicer(Class aspectClass,Method beforeMethod,Method afterMethod){
        this.aspectClass = aspectClass;
        this.beforeMethod = beforeMethod;
        this.afterMethod = afterMethod;
        try {
            this.instance = aspectClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SneakyThrows
    public Object invocateBefore(){
        Object invoke = beforeMethod.invoke(this.instance, null);
        return invoke;

    }

    @SneakyThrows
    public Object invocateAfter(){
        Object invoke = afterMethod.invoke(this.instance, null);
        return invoke;

    }
}
