package com.mashibing.tank.cor;

import com.mashibing.tank.GameModel;
import com.mashibing.tank.pojo.Bullet;
import com.mashibing.tank.pojo.Expolde;
import com.mashibing.tank.pojo.Tank;
import com.mashibing.tank.pojo.base.BaseGameObject;

public class BulletTankCollider implements Collider {

    @Override
    public boolean collide(BaseGameObject o1, BaseGameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Tank) {
            Bullet b = (Bullet) o1;
            Tank t = (Tank) o2;
            return collideWith(b, t);
        } else if (o2 instanceof Bullet && o1 instanceof Tank) {
            return collide(o2, o1);
        }
        return true;
    }

    private boolean collideWith(Bullet b, Tank t) {
        if (b.getGroup() == t.getGroup()) return true;
        if (b.getRect().intersects(t.getRect())) {
            t.die();
            b.die();
            int eX = t.getX() + Tank.WIDTH / 2 - Expolde.WIDTH / 2;
            int eY = t.getY() + Tank.HEIGHT / 2 - Expolde.HEIGHT / 2;
            GameModel gm = b.getGm();
            gm.add(gm.getGf().createExpolde(eX, eY, gm));
            return false;
        }
        return true;
    }
}
