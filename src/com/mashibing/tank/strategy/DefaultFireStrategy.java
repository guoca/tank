package com.mashibing.tank.strategy;

import com.mashibing.tank.GameModel;
import com.mashibing.tank.decorator.RectDecorator;
import com.mashibing.tank.enums.Group;
import com.mashibing.tank.pojo.Bullet;
import com.mashibing.tank.pojo.Tank;
import com.mashibing.tank.pojo.base.BaseBullet;
import com.mashibing.tank.pojo.base.BaseTank;
import com.mashibing.tank.util.AudioUtil;

public class DefaultFireStrategy implements FireStrategy {
    @Override
    public void fire(BaseTank t) {
        int bx = t.getX() + BaseTank.WIDTH / 2 - BaseBullet.WIDTH / 2;
        int by = t.getY() + BaseTank.HEIGHT / 2 - BaseBullet.HEIGHT / 2;
        GameModel.getInstance().getGf().createBullet(bx, by, t.getDir(), t.getGroup());
        if (t.getGroup() == Group.GOOD) new Thread(() -> new AudioUtil("audio/tank_fire.wav").play()).start();
    }
}
