package com.mashibing.tank.pojo;

import com.mashibing.tank.GameModel;
import com.mashibing.tank.util.AudioUtil;
import com.mashibing.tank.singleton.ResMgr;
import com.mashibing.tank.TankFrame;
import com.mashibing.tank.pojo.base.BaseExpolde;

import java.awt.*;

public class Expolde extends BaseExpolde {
    public static final int WIDTH = ResMgr.explodeArr[0].getWidth();
    public static final int HEIGHT = ResMgr.explodeArr[0].getHeight();
    private int i = 0;
    private GameModel gm;

    public Expolde(int x, int y, GameModel gm) {
        super(x,y);
        this.gm = gm;
        //爆炸音效
        new Thread(() -> new AudioUtil("audio/explode.wav").play()).start();
    }

    public void paint(Graphics g) {
        g.drawImage(ResMgr.explodeArr[i++], x, y, null);
        if (i >= ResMgr.explodeArr.length) gm.remove(this);
    }


}

