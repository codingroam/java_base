package com.acme.proxy.javaproxy;

import java.lang.reflect.Proxy;

/**
 * 缺点：①java动态代理要求代理类必须有父类
 *      ②代理逻辑无法模块化切入，要实现必须编写逻辑框架
 *
 */
public class JavaProxyMain {


    public static void main(String[] args) {
        Order order = new OrderImpl();
        Order orderProxy = (Order)Proxy.newProxyInstance(Order.class.getClassLoader(), new Class[]{Order.class}, new OrderProxyHandler(order));
        orderProxy.takeOrder();
    }
}
