package com.mashibing.tank.pojo.base;

import com.mashibing.tank.pojo.Tank;

import java.awt.*;

public abstract class BaseBullet {
    public abstract void paint(Graphics g);
    public abstract void collideWith(BaseTank t);
}
