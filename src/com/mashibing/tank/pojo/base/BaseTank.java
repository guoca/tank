package com.mashibing.tank.pojo.base;

import com.mashibing.tank.GameModel;
import com.mashibing.tank.enums.Dir;
import com.mashibing.tank.enums.Group;
import com.mashibing.tank.observer.TankHandler;
import com.mashibing.tank.singleton.GlobalConfig;
import com.mashibing.tank.singleton.ResMgr;
import com.mashibing.tank.strategy.FireContext;
import com.mashibing.tank.strategy.FireStrategyEnum;

import java.awt.*;
import java.util.Random;

public abstract class BaseTank extends BaseGameObject implements Movable {

    public static final Random RANDOM = new Random();
    public static final int WIDTH = ResMgr.bTankD.getWidth();
    public static final int HEIGHT = ResMgr.bTankD.getHeight();
    public static final int SPEED = GlobalConfig.TANK_SPEED;
    protected boolean living = true;

    protected int ox, oy;
    protected Group group;
    protected Dir dir;
    protected boolean moving = false;

    public BaseTank(int x, int y, Dir dir, Group group) {
        super(x, y, WIDTH, HEIGHT);
        this.dir = dir;
        this.group = group;
        rect = new Rectangle(x, y, WIDTH, HEIGHT);
        //添加观察者
        addObserver(new TankHandler());
    }

    /**
     * 销毁
     */
    public void die() {
        this.living = false;
        GameModel.getInstance().remove(this);
        System.out.println("我是被观察者，我被击毙了，临死前通知观察者***********************************");
        setChanged();
        notifyObservers("我被击中了，要死了……");
    }


    /**
     * 开火
     */
    public void fire() {
        FireContext.getInstance().fire(this, FireStrategyEnum.DEFAULT);
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

    public boolean isMoving() {
        return moving;
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
