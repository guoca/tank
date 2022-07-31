package com.mashibing.tank.chain;

import com.mashibing.tank.pojo.base.BaseGameObject;

public interface Collider {
    boolean collide(BaseGameObject o1, BaseGameObject o2);
}
