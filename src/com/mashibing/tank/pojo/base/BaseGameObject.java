package com.mashibing.tank.pojo.base;

import java.awt.*;

public abstract class BaseGameObject {
    protected int x, y, width, height;

    public BaseGameObject() {
    }

    public BaseGameObject(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public BaseGameObject(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public abstract void paint(Graphics g);

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
