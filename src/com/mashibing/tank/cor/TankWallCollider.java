package com.mashibing.tank.cor;

import com.mashibing.tank.pojo.Tank;
import com.mashibing.tank.pojo.Wall;
import com.mashibing.tank.pojo.base.BaseGameObject;

public class TankWallCollider implements Collider {
    @Override
    public boolean collide(BaseGameObject o1, BaseGameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Wall) {
            Tank t1 = (Tank) o1;
            Wall t2 = (Wall) o2;
            if (t1.getRect().intersects(t2.getRect())) {
                t1.back();
            }
        } else if (o2 instanceof Tank && o1 instanceof Wall) {
            return collide(o2, o1);
        }
        return true;

    }


}
