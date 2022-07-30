package com.mashibing.tank.factory;

import com.mashibing.tank.TankFrame;
import com.mashibing.tank.enums.Dir;
import com.mashibing.tank.enums.Group;
import com.mashibing.tank.pojo.Bullet;
import com.mashibing.tank.pojo.BulletBig;
import com.mashibing.tank.pojo.Expolde;
import com.mashibing.tank.pojo.Tank;
import com.mashibing.tank.pojo.base.BaseBullet;
import com.mashibing.tank.pojo.base.BaseExpolde;
import com.mashibing.tank.pojo.base.BaseTank;

/**
 * 默认工厂
 */
public class BigFactory extends GameFactory {
    @Override
    public BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tf) {
        return new Tank(x, y, dir, group, tf);
    }

    @Override
    public BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        return new BulletBig(x, y, dir, group, tf);
    }

    @Override
    public BaseExpolde createExpolde(int x, int y, TankFrame tf) {
        return new Expolde(x, y, tf);
    }
}
