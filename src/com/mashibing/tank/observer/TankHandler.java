package com.mashibing.tank.observer;

import com.mashibing.tank.pojo.base.BaseTank;

/**
 * 坦克销毁处理者
 */
public class TankHandler extends TankObserver {
    @Override
    public void actionOnDie(TankFireEvent e) {
        BaseTank t = (BaseTank) e.getSource();
        System.out.println("我是观察者，观察到坦克的die()方法被调用，并且坦克【" + t.getId() + "】说了句：" + e.getArg());
    }


}
