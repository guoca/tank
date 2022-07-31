package com.mashibing.tank.pojo.base;

import com.mashibing.tank.enums.Dir;
import com.mashibing.tank.enums.Group;
import com.mashibing.tank.singleton.ResMgr;

public abstract class BaseBullet extends BaseGameObject {

    protected Dir dir;
    protected Group group;
    protected boolean living = true;

    public BaseBullet(int x, int y, Dir dir, Group group) {
        super(x, y, ResMgr.bulletD.getWidth(), ResMgr.bulletD.getHeight());
        this.dir = dir;
        this.group = group;
    }

    public void die() {
        this.living = false;
    }

    public Dir getDir() {
        return dir;
    }

    public Group getGroup() {
        return group;
    }
}
