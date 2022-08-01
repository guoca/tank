package com.mashibing.tank.factory;

import com.mashibing.tank.enums.Dir;
import com.mashibing.tank.enums.Group;
import com.mashibing.tank.flyweight.BulletPool;
import com.mashibing.tank.pojo.Expolde;
import com.mashibing.tank.pojo.Tank;
import com.mashibing.tank.pojo.base.BaseBullet;
import com.mashibing.tank.pojo.base.BaseExpolde;
import com.mashibing.tank.pojo.base.BaseTank;
import com.mashibing.tank.proxy.NoOpInterceptor;
import com.mashibing.tank.proxy.TimeIntercepter;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.Enhancer;

import java.io.Serializable;

/**
 * 默认工厂
 */
public class DefaultFactory extends GameFactory implements Serializable {

    // 通知
    static transient Callback[] advices = new Callback[] { new NoOpInterceptor()/*默认什么都不做*/, new TimeIntercepter() };

    static CallbackFilter pointCut = method -> {
        switch (method.getName()) {
            case "die" : return 1; // die() 方法植入通知
            default: return 0; // 其他方法不添加通知
        }
    };

    @Override
    public BaseTank createTank(int x, int y, Dir dir, Group group) {
        Enhancer e = new Enhancer();
        e.setSuperclass(Tank.class);
        e.setInterfaces(new Class[]{Serializable.class});
//        e.setCallback(new TimeIntercepter());
        e.setCallbacks(advices);
        e.setCallbackFilter(pointCut);
        BaseTank t = (BaseTank) e.create(new Class[]{int.class, int.class, Dir.class, Group.class}, new Object[]{x, y, dir, group});
        return t;
    }

    @Override
    public BaseBullet createBullet(int x, int y, Dir dir, Group group) {
        return BulletPool.getInstance().getBullet(x, y, dir, group);
    }

    @Override
    public BaseExpolde createExpolde(int x, int y) {
        System.out.println("************抽象工厂模式创建爆炸对象************");
        return new Expolde(x, y);
    }
}