package com.mashibing.tank.strategy;

import com.mashibing.tank.GameModel;
import com.mashibing.tank.enums.Group;
import com.mashibing.tank.pojo.base.BaseBullet;
import com.mashibing.tank.pojo.base.BaseTank;
import com.mashibing.tank.singleton.GlobalConfig;
import com.mashibing.tank.util.AudioUtil;

public class DefaultFireStrategy implements FireStrategy {
    @Override
    public void fire(BaseTank t) {
        System.out.println("默认开火策略*****");
        int bx = t.getX() + GlobalConfig.TANK_WIDTH / 2 - GlobalConfig.BULLET_WIDTH / 2;
        int by = t.getY() + GlobalConfig.TANK_HEIGHT / 2 - GlobalConfig.BULLET_HEIGHT / 2;
        GameModel gm = GameModel.getInstance();
        BaseBullet bullet = gm.getGf().createBullet(bx, by, t.getDir(), t.getGroup());
        gm.add(bullet);
        if (t.getGroup() == Group.GOOD) new Thread(() -> new AudioUtil("audio/tank_fire.wav").play()).start();
    }
}
