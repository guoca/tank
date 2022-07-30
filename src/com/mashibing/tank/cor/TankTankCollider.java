package com.mashibing.tank.cor;

import com.mashibing.tank.pojo.Tank;
import com.mashibing.tank.pojo.base.BaseGameObject;

public class TankTankCollider implements Collider {
    @Override
    public boolean collide(BaseGameObject o1, BaseGameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Tank && o1!=o2) {
            Tank t1 = (Tank) o1;
            Tank t2 = (Tank) o2;
            if (t1.getRect().intersects(t2.getRect())) {
                t1.back();
                t2.back();
            }
        }
        return true;

    }


}
