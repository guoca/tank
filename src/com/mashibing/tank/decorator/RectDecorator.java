package com.mashibing.tank.decorator;

import com.mashibing.tank.pojo.base.BaseGameObject;

import java.awt.*;

/**
 * 矩形装饰类
 */
public class RectDecorator extends BgoDecorator {
    public RectDecorator(BaseGameObject bgo) {
        super(bgo);
    }

    @Override
    public void paint(Graphics g) {
        x = bgo.getX();
        y = bgo.getY();
        Color c = g.getColor();
        g.setColor(Color.YELLOW);
        g.drawRect(x, y, width + 5, height + 5);
        g.setColor(c);
    }
}
