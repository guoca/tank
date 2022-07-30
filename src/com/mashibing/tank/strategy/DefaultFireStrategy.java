package com.mashibing.tank.strategy;

import com.mashibing.tank.util.AudioUtil;
import com.mashibing.tank.enums.Group;
import com.mashibing.tank.pojo.Bullet;
import com.mashibing.tank.pojo.Tank;
import com.mashibing.tank.pojo.base.BaseTank;

public class DefaultFireStrategy implements FireStrategy {
    @Override
    public void fire(BaseTank t) {
        int bx = t.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int by = t.getY() + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        t.getGm().getGf().createBullet(bx, by, t.getDir(), t.getGroup(), t.getGm());
        if (t.getGroup() == Group.GOOD) new Thread(() -> new AudioUtil("audio/tank_fire.wav").play()).start();
    }
}
