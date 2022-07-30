package com.mashibing.tank;

import com.mashibing.tank.enums.Dir;
import com.mashibing.tank.enums.Group;
import com.mashibing.tank.factory.DefaultFactory;
import com.mashibing.tank.factory.GameFactory;
import com.mashibing.tank.pojo.base.BaseBullet;
import com.mashibing.tank.pojo.base.BaseExpolde;
import com.mashibing.tank.pojo.base.BaseTank;
import com.mashibing.tank.singleton.GlobalConfig;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameModel {

    private BaseTank mainTank;
    private GameFactory gf;

    public GameModel() {
        int tankCount = GlobalConfig.INIT_TANK_COUNT;
        gf = new DefaultFactory();
        for (int i = 0; i < tankCount; i++) {
            gettList().add(getGf().createTank(50 + i * 80, 200, Dir.DOWN, Group.BAD, this));
        }

        this.gf = gf;
        mainTank = gf.createTank(200, 400, Dir.DOWN, Group.GOOD, this);
    }

    private List<BaseTank> tList = new ArrayList<>();
    private List<BaseBullet> bList = new ArrayList<>();
    private List<BaseExpolde> eList = new ArrayList<>();

    public BaseTank getMainTank() {
        return mainTank;
    }

    public List<BaseTank> gettList() {
        return tList;
    }

    public List<BaseBullet> getbList() {
        return bList;
    }

    public List<BaseExpolde> geteList() {
        return eList;
    }

    public GameFactory getGf() {
        return gf;
    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹的数量：" + bList.size(), 10, 60);
        g.drawString("敌人的数量：" + tList.size(), 10, 80);
        g.setColor(c);
        mainTank.paint(g);
        for (int i = 0; i < bList.size(); i++) {
            bList.get(i).paint(g);
        }
        for (int i = 0; i < tList.size(); i++) {
            tList.get(i).paint(g);
        }
        for (int i = 0; i < eList.size(); i++) {
            eList.get(i).paint(g);
        }
        for (int i = 0; i < bList.size(); i++) {
            BaseBullet b = bList.get(i);
            for (int j = 0; j < tList.size(); j++) {
                b.collideWith(tList.get(j));
            }
        }
    }
}
