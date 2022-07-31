package com.mashibing.tank.chain;

import com.mashibing.tank.pojo.Bullet;
import com.mashibing.tank.pojo.Wall;
import com.mashibing.tank.pojo.base.BaseBullet;
import com.mashibing.tank.pojo.base.BaseGameObject;
import com.mashibing.tank.pojo.base.BaseWall;

public class BulletWallCollider implements Collider {

    @Override
    public boolean collide(BaseGameObject o1, BaseGameObject o2) {
        if (o1 instanceof BaseBullet && o2 instanceof BaseWall) {
            BaseBullet b = (BaseBullet) o1;
            BaseWall t = (BaseWall) o2;
            if (b.getRect().intersects(t.getRect())) {
                b.die();
            }
        } else if (o2 instanceof Bullet && o1 instanceof Wall) {
            return collide(o2, o1);
        }
        return true;
    }

}
