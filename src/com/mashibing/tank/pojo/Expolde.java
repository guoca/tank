package com.mashibing.tank.pojo;

import com.mashibing.tank.GameModel;
import com.mashibing.tank.pojo.base.BaseExpolde;
import com.mashibing.tank.singleton.ResMgr;
import com.mashibing.tank.util.AudioUtil;

import java.awt.*;

public class Expolde extends BaseExpolde {

    private int i = 0;

    public Expolde(int x, int y) {
        super(x, y);
        //爆炸音效
        new Thread(() -> new AudioUtil("audio/explode.wav").play()).start();
        GameModel.getInstance().add(this);
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(ResMgr.explodeArr[i++], x, y, null);
        if (i >= ResMgr.explodeArr.length) GameModel.getInstance().remove(this);
    }


}

