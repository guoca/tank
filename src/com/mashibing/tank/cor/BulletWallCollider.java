package com.mashibing.tank.cor;

import com.mashibing.tank.pojo.Bullet;
import com.mashibing.tank.pojo.Wall;
import com.mashibing.tank.pojo.base.BaseGameObject;

public class BulletWallCollider implements Collider {

    @Override
    public boolean collide(BaseGameObject o1, BaseGameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Wall) {
            Bullet b = (Bullet) o1;
            Wall t = (Wall) o2;
            if (b.getRect().intersects(t.getRect())) {
                b.die();
            }
        } else if (o2 instanceof Bullet && o1 instanceof Wall) {
            return collide(o2, o1);
        }
        return true;
    }

}
