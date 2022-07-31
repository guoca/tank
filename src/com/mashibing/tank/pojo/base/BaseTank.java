package com.mashibing.tank.pojo.base;

import com.mashibing.tank.GameModel;
import com.mashibing.tank.enums.Dir;
import com.mashibing.tank.enums.Group;
import com.mashibing.tank.singleton.GlobalConfig;
import com.mashibing.tank.singleton.ResMgr;
import com.mashibing.tank.strategy.FireStrategy;

import java.awt.*;
import java.util.Random;

public abstract class BaseTank extends BaseGameObject {

    public static final Random RANDOM = new Random();
    public static final int WIDTH = ResMgr.bTankD.getWidth();
    public static final int HEIGHT = ResMgr.bTankD.getHeight();
    public static final int SPEED = GlobalConfig.TANK_SPEED;

    protected int ox, oy;
    protected Group group;
    protected Dir dir;
    protected boolean moving = false;
    protected boolean living = true;
    protected FireStrategy fs;

    public BaseTank(int x, int y, Dir dir, Group group) {
        super(x, y, WIDTH, HEIGHT);
        this.dir = dir;
        this.group = group;
        rect = new Rectangle(x, y, WIDTH, HEIGHT);
        String fsName = GlobalConfig.BAD_TANK_FIRE_STRATEGY;
        if (this.group == Group.GOOD) {
            fsName = GlobalConfig.GOOD_TANK_FIRE_STRATEGY;
        }
        try {
            this.fs = (FireStrategy) Class.forName(fsName).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 销毁
     */
    public void die() {
        this.living = false;
    }


    /**
     * 开火
     */
    public void fire() {
        fs.fire(this);
    }


    public Group getGroup() {
        return group;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    /**
     * 随机转向
     */
    public void randomChangeDir() {
        int i = RANDOM.nextInt(4);
        int ordinal = dir.ordinal();
        while (ordinal != i) {
            break;
        }
        dir = Dir.values()[i];
    }

    /**
     * 回退
     */
    public void back() {
        x = ox;
        y = oy;
    }
}
