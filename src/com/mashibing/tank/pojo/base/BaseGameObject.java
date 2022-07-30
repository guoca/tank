package com.mashibing.tank.pojo.base;

import com.mashibing.tank.GameModel;

import java.awt.*;

public abstract class BaseGameObject {
    protected int x, y;
    protected GameModel gm;

    public BaseGameObject(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public GameModel getGm() {
        return gm;
    }

    public abstract void paint(Graphics g);
}
