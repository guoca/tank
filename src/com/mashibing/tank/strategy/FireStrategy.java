package com.mashibing.tank.strategy;

import com.mashibing.tank.pojo.Tank;
import com.mashibing.tank.pojo.base.BaseTank;

/**
 * 开火策略
 */
public interface FireStrategy {
    void fire(BaseTank t);
}
