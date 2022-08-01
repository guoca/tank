package com.mashibing.tank.pojo.base;

import com.mashibing.tank.GameModel;
import com.mashibing.tank.enums.Dir;
import com.mashibing.tank.enums.Group;
import com.mashibing.tank.singleton.GlobalConfig;
import com.mashibing.tank.singleton.ResMgr;

import java.awt.*;

public abstract class BaseBullet extends BaseGameObject implements Movable {

    protected Dir dir;
    protected Group group;
    public static final int SPEED = GlobalConfig.TANK_SPEED;

    public BaseBullet(int x, int y, Dir dir, Group group) {
        super(x, y, ResMgr.bulletD.getWidth(), ResMgr.bulletD.getHeight());
        this.dir = dir;
        this.group = group;
    }


    /**
     * 重置
     *
     * @param x
     * @param y
     * @param dir
     * @param group
     * @return
     */
    public void reset(int x, int y, Dir dir, Group group) {
        living = true;
        this.x = x;
        this.y = y;
        this.rect = new Rectangle(x, y, width, height);
        this.dir = dir;
        this.group = group;
    }

    /**
     * 销毁
     */
    public void die() {
        living = false;
        GameModel.getInstance().remove(this);
    }

    public Dir getDir() {
        return dir;
    }

    public Group getGroup() {
        return group;
    }
}
