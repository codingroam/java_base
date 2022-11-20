package com.acme.imitate_springaop;

import com.acme.imitate_springaop.senior_version.aop.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;


/**
 * @Description TODO
 * @Author wangkai
 * @Date 2022/11/15 21:40
 */

@MAspect
@Slf4j
public class LogAspects {


    @MBefore("pointcut()")
    public void logStart(JoinPoint joinPoint){
        //System.out.println("除法运行，参数是{}");
        log.info("Before advice 方法{}运行，参数是{}",joinPoint.getSignature().getName(), Arrays.asList(joinPoint.getArgs()));

    }

    @MAfter("pointcut()")
    public void logEnd(JoinPoint joinPoint){
        //System.out.println("除法结束");
        log.info("After advice 方法{}运行结束，参数是{}",joinPoint.getSignature().getName(),Arrays.asList(joinPoint.getArgs()));
    }

    @Pointcut(clazz=MathCalculator.class,method = "div",args={Integer.class,Integer.class})
    public void pointcut(){
    }
}
