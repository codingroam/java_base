package com.acme.imitate_springaop.senior_version.aop;

public class AspectJBeforeAdvice implements AspectJMethodInterceptor{

    @Override
    public Object invoke(ReflectiveMethodInvocation reflectiveMethodInvocation) throws Throwable {
        reflectiveMethodInvocation.proceed();

        return null;
    }
}
