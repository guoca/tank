package com.mashibing.tank.pojo;

import com.mashibing.tank.GameModel;
import com.mashibing.tank.pojo.base.BaseWall;

import java.awt.*;

public class Wall extends BaseWall {

    public Wall(int x, int y, int w, int h) {
        super(x, y, w, h);
        GameModel.getInstance().add(this);
    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.DARK_GRAY);
        g.fillRect(x, y, w, h);
        g.setColor(c);
    }
}
