package com.mashibing.tank.cor;

import com.mashibing.tank.GameModel;
import com.mashibing.tank.pojo.Bullet;
import com.mashibing.tank.pojo.Tank;
import com.mashibing.tank.pojo.base.BaseBullet;
import com.mashibing.tank.pojo.base.BaseGameObject;
import com.mashibing.tank.pojo.base.BaseTank;
import com.mashibing.tank.singleton.GlobalConfig;

public class BulletTankCollider implements Collider {

    @Override
    public boolean collide(BaseGameObject o1, BaseGameObject o2) {
        if (o1 instanceof BaseBullet && o2 instanceof BaseTank) {
            BaseBullet b = (BaseBullet) o1;
            BaseTank t = (BaseTank) o2;
            return collideWith(b, t);
        } else if (o2 instanceof Bullet && o1 instanceof Tank) {
            return collide(o2, o1);
        }
        return true;
    }

    private boolean collideWith(BaseBullet b, BaseTank t) {
        if (b.getGroup() == t.getGroup()) return true;
        if (b.getRect().intersects(t.getRect())) {
            t.die();
            b.die();
            int eX = t.getX() + GlobalConfig.TANK_WIDTH / 2 - GlobalConfig.EXPOLDE_WIDTH / 2;
            int eY = t.getY() + GlobalConfig.TANK_HEIGHT / 2 - GlobalConfig.EXPOLDE_HEIGHT / 2;
            GameModel.getInstance().getGf().createExpolde(eX, eY);
            return false;
        }
        return true;
    }
}
