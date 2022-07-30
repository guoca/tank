package com.mashibing.tank.factory;

import com.mashibing.tank.GameModel;
import com.mashibing.tank.enums.Dir;
import com.mashibing.tank.enums.Group;
import com.mashibing.tank.pojo.Bullet;
import com.mashibing.tank.pojo.Expolde;
import com.mashibing.tank.pojo.Tank;
import com.mashibing.tank.pojo.base.BaseBullet;
import com.mashibing.tank.pojo.base.BaseExpolde;
import com.mashibing.tank.pojo.base.BaseTank;

/**
 * 默认工厂
 */
public class DefaultFactory extends GameFactory {
    @Override
    public BaseTank createTank(int x, int y, Dir dir, Group group) {
        return new Tank(x, y, dir, group);
    }

    @Override
    public BaseBullet createBullet(int x, int y, Dir dir, Group group) {
        return new Bullet(x, y, dir, group);
    }

    @Override
    public BaseExpolde createExpolde(int x, int y) {
        return new Expolde(x, y);
    }
}
