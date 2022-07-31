package com.mashibing.tank.pojo.base;

import com.mashibing.tank.singleton.ResMgr;

public abstract class BaseExpolde extends BaseGameObject {
    public static final int WIDTH = ResMgr.explodeArr[0].getWidth();
    public static final int HEIGHT = ResMgr.explodeArr[0].getHeight();

    public BaseExpolde(int x, int y) {
        super(x, y, WIDTH, HEIGHT);
    }
}
