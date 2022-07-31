package com.mashibing.tank.pojo.base;

import com.mashibing.tank.singleton.GlobalConfig;

public abstract class BaseExpolde extends BaseGameObject {

    public BaseExpolde(int x, int y) {
        super(x, y, GlobalConfig.EXPOLDE_WIDTH, GlobalConfig.EXPOLDE_HEIGHT);
    }
}
