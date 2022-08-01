package com.mashibing.tank.pojo.base;

import java.awt.*;
import java.io.Serializable;
import java.util.Observable;
import java.util.UUID;

public abstract class BaseGameObject extends Observable implements Serializable {
    protected UUID id = UUID.randomUUID();
    protected  boolean  living = true;
    protected  boolean  suspending = false;
    protected int x, y, width, height;
    protected Rectangle rect;

    public BaseGameObject() {
    }


    public BaseGameObject(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.rect = new Rectangle(x, y, width, height);
    }

    public abstract void paint(Graphics g);

    public UUID getId() {
        return id;
    }

    public boolean isLiving() {
        return living;
    }

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

    public Rectangle getRect() {
        return rect;
    }

    public boolean isSuspending() {
        return suspending;
    }

    public void setSuspending(boolean suspending) {
        this.suspending = suspending;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " {" +
                "id=" + id +
                ", living=" + living +
                ", x=" + x +
                ", y=" + y +
                ", width=" + width +
                ", height=" + height +
                ", rect=" + rect +
                '}';
    }
}
