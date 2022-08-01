package com.mashibing.tank.strategy;

import com.mashibing.tank.pojo.base.BaseTank;

import java.io.Serializable;

/**
 * 开火策略
 */
public interface FireStrategy extends Serializable {
    void fire(BaseTank t);
}
