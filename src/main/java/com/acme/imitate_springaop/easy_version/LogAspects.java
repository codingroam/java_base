package com.acme.imitate_springaop.easy_version;

import com.acme.imitate_springaop.MathCalculator;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;


/**
 * @Description TODO
 * @Author wangkai
 * @Date 2022/11/15 21:40
 */

@Slf4j
public class LogAspects {



    public void logStart(){
        //System.out.println("除法运行，参数是{}");
        log.info("Before advice 方法{}运行，参数是{}");

    }


    public void logEnd(){
        //System.out.println("除法结束");
        log.info("After advice 方法{}运行结束，参数是{}");
    }
//
//    @Pointcut(clazz= MathCalculator.class,method = "div",args={Integer.class,Integer.class})
//    public void pointcut(){
//    }
}
