package com.mashibing.tank.strategy;

import com.mashibing.tank.util.AudioUtil;
import com.mashibing.tank.enums.Dir;
import com.mashibing.tank.enums.Group;
import com.mashibing.tank.pojo.Bullet;
import com.mashibing.tank.pojo.Tank;
import com.mashibing.tank.pojo.base.BaseTank;

public class FourDirFireStrategy implements FireStrategy {
    @Override
    public void fire(BaseTank t) {
        int bx = t.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int by = t.getY() + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        Dir[] dirs = Dir.values();
        for (Dir dir : dirs) {
            t.getTf().getGf().createBullet(bx, by, dir, t.getGroup(), t.getTf());
        }
        if (t.getGroup() == Group.GOOD) new Thread(() -> new AudioUtil("audio/tank_fire.wav").play()).start();

    }
}