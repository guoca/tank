package com.mashibing.tank.pojo.base;

import com.mashibing.tank.singleton.GlobalConfig;
import com.mashibing.tank.singleton.ResMgr;

public abstract class BaseBullet extends BaseGameObject {
    public static final int SPEED = GlobalConfig.BULLET_SPEED;
    public static final int WIDTH = ResMgr.bulletD.getWidth();
    public static final int HEIGHT = ResMgr.bulletD.getHeight();

    public BaseBullet(int x, int y) {
        super(x, y, WIDTH, HEIGHT);
    }
}
