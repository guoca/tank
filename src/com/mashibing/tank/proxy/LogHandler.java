package com.mashibing.tank.proxy;

import com.mashibing.tank.enums.Group;
import com.mashibing.tank.pojo.base.BaseTank;
import com.mashibing.tank.pojo.base.Movable;
import com.mashibing.tank.singleton.GlobalConfig;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理给移动方法添加日志
 */
public class LogHandler implements InvocationHandler {
    Movable m;
    BaseTank t;
    boolean logFlag = false;

    public LogHandler(Movable m) {
        this.m = m;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (m instanceof BaseTank) {
            t = (BaseTank) m;
            if (t.getGroup() == Group.GOOD && t.isMoving()) {
                logFlag = true;
            }
        }
        Object o = method.invoke(m, args);
        if (logFlag) {
            System.out.println("我是jdk动态代理，正在代理坦克的move方法************");
            System.out.println("主战坦克向" + t.getDir().getDesc() + "移动：" + GlobalConfig.TANK_SPEED);
            System.out.println("jdk动态代理结束********************************");
        }

        return o;
    }

}
