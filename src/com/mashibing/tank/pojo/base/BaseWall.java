package com.mashibing.tank.pojo.base;

import java.awt.*;

public abstract class BaseWall extends BaseGameObject {
    protected int w, h;
    public Rectangle rect;

    public BaseWall(int x, int y,int w, int h) {
        super(x,y);
        this.w = w;
        this.h = h;
        this.rect = new Rectangle(x, y, w, h);
    }
}
