package com.mashibing.tank.factory;

import com.mashibing.tank.enums.Dir;
import com.mashibing.tank.enums.Group;
import com.mashibing.tank.pojo.base.BaseBullet;
import com.mashibing.tank.pojo.base.BaseExpolde;
import com.mashibing.tank.pojo.base.BaseTank;

/**
 * 游戏工厂
 */
public abstract class GameFactory {

    public abstract BaseTank createTank(int x, int y, Dir dir, Group group);

    public abstract BaseBullet createBullet(int x, int y, Dir dir, Group group);

    public abstract BaseExpolde createExpolde(int x, int y);
}
