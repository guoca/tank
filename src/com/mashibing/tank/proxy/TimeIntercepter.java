package com.mashibing.tank.proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.io.Serializable;
import java.lang.reflect.Method;

public class TimeIntercepter implements MethodInterceptor, Serializable {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib代理开始*************************************");
        System.out.println("我的父类是"+o.getClass().getSuperclass().getSimpleName()+"，我将代理它的"+method.getName()+"()方法。");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("cglib代理结束*************************************");
        return result;
    }
}
