package com.mashibing.tank.pojo.base;

import com.mashibing.tank.*;
import com.mashibing.tank.enums.Dir;
import com.mashibing.tank.enums.Group;
import com.mashibing.tank.singleton.GlobalConfig;
import com.mashibing.tank.singleton.ResMgr;
import com.mashibing.tank.strategy.FireStrategy;

import java.awt.*;
import java.util.Random;

public abstract class BaseTank {

    public static final int WIDTH = ResMgr.bTankD.getWidth();
    public static final int HEIGHT = ResMgr.bTankD.getHeight();
    public static final Random RANDOM = new Random();

    protected static final int SPEED = GlobalConfig.TANK_SPEED;
    protected int x, y;
    protected Group group = Group.BAD;
    protected Dir dir = Dir.DOWN;
    protected boolean moving = false;
    protected boolean living = true;
    protected TankFrame tf;
    protected FireStrategy fs;
    protected Rectangle rect = new Rectangle(x, y, WIDTH, HEIGHT);
    /**
     * 销毁
     */
    public void die() {
        this.living = false;
    }

    /**
     * 获取坦克坐标
     *
     * @return
     */
    public Rectangle getRect() {
        return this.rect;
    }

    /**
     * 开火
     */
    public void fire() {
        fs.fire(this);
    }

    public abstract void paint(Graphics g);

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Group getGroup() {
        return group;
    }

    public Dir getDir() {
        return dir;
    }

    public boolean isMoving() {
        return moving;
    }

    public boolean isLiving() {
        return living;
    }

    public TankFrame getTf() {
        return tf;
    }

    public FireStrategy getFs() {
        return fs;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }
}