package com.mashibing.tank;

import java.awt.*;

public class Expolde {
    public static final int WIDTH = ResMgr.explodeArr[0].getWidth();
    public static final int HEIGHT = ResMgr.explodeArr[0].getHeight();
    private int x, y;
    private int i = 0;
    private TankFrame tf = null;

    public Expolde(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
        new Thread(()->new Audio("audio/explode.wav").play()).start();
    }

    public void paint(Graphics g) {
        g.drawImage(ResMgr.explodeArr[i++], x, y, null);
        if (i >= ResMgr.explodeArr.length) tf.eList.remove(this);
    }


}

