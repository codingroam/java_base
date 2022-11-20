package com.acme.imitate_springaop.senior_version.aop.advice;

import java.lang.reflect.Method;

public class AbstractAspectJMethodBeforeAdvice extends AbstractAspectJMethodAdvice implements MethodBeforeAdvice{
    @Override
    public void before(Method method, Object[] args) {

    }
}
