package com.acme.imitate_springaop.senior_version.aop.advice;

import java.lang.reflect.Method;

public interface MethodBeforeAdvice extends BeforeAdvice{
    void before(Method method, Object[] args);
}
