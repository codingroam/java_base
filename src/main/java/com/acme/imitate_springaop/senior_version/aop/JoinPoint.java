package com.acme.imitate_springaop.senior_version.aop;

import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class JoinPoint {

    private List<Object> args = new ArrayList<>();

    private  Method method;

    public Method getSignature(){
        return method;
    }




}
