package com.mashibing.tank.cor;

import com.mashibing.tank.enums.Group;
import com.mashibing.tank.pojo.Tank;
import com.mashibing.tank.pojo.base.BaseGameObject;

public class TankTankCollider implements Collider {
    @Override
    public boolean collide(BaseGameObject o1, BaseGameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Tank) {
            Tank t1 = (Tank) o1;
            Tank t2 = (Tank) o2;
            return collideWith(t1, t2);
        }
        return true;

    }

    private boolean collideWith(Tank t1, Tank t2) {
        if (t1.getRect().intersects(t2.getRect())) {
            if (t1.getGroup() == Group.BAD) {
                t1.randomChangeDir();
            }
            if (t2.getGroup() == Group.BAD) {
                t2.randomChangeDir();
            }

            return false;
        }
        return true;
    }

}
