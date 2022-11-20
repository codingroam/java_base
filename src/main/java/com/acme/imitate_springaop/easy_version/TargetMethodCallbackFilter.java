package com.acme.imitate_springaop.easy_version;

import net.sf.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

public class TargetMethodCallbackFilter implements CallbackFilter {
 
    /**
     * 过滤方法
     * 返回的值为数字，代表了Callback数组中的索引位置，要到用的Callback
     */
    @Override
    public int accept(Method method) {
        if(method.getName().equals("div")){
            return 0;
        }
        return 1;
    }
 
}