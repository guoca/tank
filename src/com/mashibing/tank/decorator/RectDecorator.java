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
    protected void paint(Graphics g, BaseGameObject bgo) {
        Graphics2D g2d = (Graphics2D) g;
        Color c = g2d.getColor();
        g2d.setColor(Color.YELLOW);
        // 设置线条宽度
        g2d.setStroke(new BasicStroke(5));
        int borderWidth = 5;
        g2d.drawRect(x - borderWidth, y - borderWidth, width + borderWidth * 2, height + borderWidth * 2);
        g2d.setColor(c);
    }

}
