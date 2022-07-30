package com.mashibing.tank.pojo.base;

import com.mashibing.tank.GameModel;

import java.awt.*;

public abstract class BaseGameObject {
    protected int x, y;

    public BaseGameObject(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract void paint(Graphics g);
}
