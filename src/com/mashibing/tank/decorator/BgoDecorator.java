package com.mashibing.tank.decorator;

import com.mashibing.tank.pojo.base.BaseGameObject;

import java.awt.*;

/**
 * 游戏物品装饰抽象类
 */
public abstract class BgoDecorator extends BaseGameObject {

    BaseGameObject bgo;

    public BgoDecorator(BaseGameObject bgo) {
        super(bgo.getX(), bgo.getY(), bgo.getWidth(), bgo.getHeight());
        this.bgo = bgo;
    }

    @Override
    public void paint(Graphics g) {
        bgo.paint(g);
    }
}
