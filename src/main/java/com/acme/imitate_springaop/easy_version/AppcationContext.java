package com.acme.imitate_springaop.easy_version;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

public class AppcationContext {

    public <T> T getBean(Class<T> aClass){

        return doGetBean(aClass);
    }

    private  <T> T doGetBean(Class<T> aClass){
        try{

            Enhancer enhancer =new Enhancer();
            enhancer.setSuperclass(aClass);
            CallbackFilter callbackFilter = new TargetMethodCallbackFilter();

            /**
             * (1)callback1：方法拦截器
             (2)NoOp.INSTANCE：这个NoOp表示no operator，即什么操作也不做，代理类直接调用被代理的方法不进行拦截。
             (3)FixedValue：表示锁定方法返回值，无论被代理类的方法返回什么值，回调方法都返回固定值。
             */
            Advicer advicer = new Advicer(LogAspects.class,LogAspects.class.getMethod("logStart",null),LogAspects.class.getMethod("logEnd",null));
            Callback callback1=new TargetInterceptor(advicer);
            Callback noopCb= NoOp.INSTANCE;

            Callback[] cbarray=new Callback[]{callback1,noopCb};
            //enhancer.setCallback(new TargetInterceptor());
            enhancer.setCallbacks(cbarray);
            enhancer.setCallbackFilter(callbackFilter);
            T t = (T)enhancer.create();
            return t;
        }catch (Exception e){
            e.printStackTrace();
        }
      return null;
    }
}
