package com.acme.repository_transaction_framework.servicetran.factory;

import com.acme.repository_transaction_framework.servicetran.proxy.ServiceProxy;
import com.acme.repository_transaction_framework.servicetran.service.BaseService;

import java.util.HashMap;
import java.util.Map;

public class ServiceFactory {

    private static Map<Class , BaseService> serviceMap = new HashMap<>();
    private static ServiceFactory serviceFactory = new ServiceFactory();
    private ServiceFactory(){
    }
    public  static ServiceFactory getInstnce(){
        return serviceFactory;
    }


    public <T extends BaseService> T getService(Class<T> clazz){
        BaseService baseServiceCache = serviceMap.get(clazz);
        if(baseServiceCache != null){
            return (T)baseServiceCache;
        }

        T baseService = null;
        synchronized (ServiceFactory.class){
            BaseService baseServiceCacheCheck = serviceMap.get(clazz);
            if(baseServiceCacheCheck != null){
                return (T)baseServiceCacheCheck;
            }

            baseService = new ServiceProxy<T>(clazz).newInstance();
            serviceMap.put(clazz,baseService);


        }

        return baseService;


    }



}
