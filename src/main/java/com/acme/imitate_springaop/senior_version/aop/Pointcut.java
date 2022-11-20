package com.acme.imitate_springaop.senior_version.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Pointcut {
    String value() default "";

    Class clazz();
    String method();
    Class[] args();
}
