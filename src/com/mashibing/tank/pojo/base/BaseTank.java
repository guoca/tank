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

    protected int ox, oy;
    public static final int WIDTH = ResMgr.bTankD.getWidth();
    public static final int HEIGHT = ResMgr.bTankD.getHeight();
    public static final Random RANDOM = new Random();

    protected static final int SPEED = GlobalConfig.TANK_SPEED;
    protected Group group = Group.BAD;
    protected Dir dir = Dir.DOWN;
    protected boolean moving = false;
    protected boolean living = true;
    protected GameModel gm;
    protected FireStrategy fs;
    protected Rectangle rect = new Rectangle(x, y, WIDTH, HEIGHT);

    public BaseTank(int x, int y) {
        super(x, y);
    }

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

    public GameModel getGm() {
        return gm;
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

    public void back() {
        x = ox;
        y = oy;
    }
}
