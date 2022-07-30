package com.mashibing.tank;

import com.mashibing.tank.cor.BulletTankCollider;
import com.mashibing.tank.cor.ColliderChain;
import com.mashibing.tank.cor.TankTankCollider;
import com.mashibing.tank.enums.Dir;
import com.mashibing.tank.enums.Group;
import com.mashibing.tank.factory.DefaultFactory;
import com.mashibing.tank.factory.GameFactory;
import com.mashibing.tank.pojo.base.BaseGameObject;
import com.mashibing.tank.pojo.base.BaseTank;
import com.mashibing.tank.singleton.GlobalConfig;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameModel {

    private BaseTank mainTank;
    private GameFactory gf;
    ColliderChain cc = new ColliderChain();
    public GameModel() {
        int tankCount = GlobalConfig.INIT_TANK_COUNT;
        gf = new DefaultFactory();
        for (int i = 0; i < tankCount; i++) {
            objList.add(getGf().createTank(50 + i * 80, 200, Dir.DOWN, Group.BAD, this));
        }

        this.gf = gf;
        mainTank = gf.createTank(200, 400, Dir.DOWN, Group.GOOD, this);
    }

    private List<BaseGameObject> objList = new ArrayList<>();

    public BaseTank getMainTank() {
        return mainTank;
    }

    public GameFactory getGf() {
        return gf;
    }

    public List<BaseGameObject> getObjList() {
        return objList;
    }

    public void add(BaseGameObject obj) {
        this.objList.add(obj);
    }

    public void remove(BaseGameObject obj) {
        this.objList.remove(obj);
    }


    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
//        g.drawString("子弹的数量：" + bList.size(), 10, 60);
//        g.drawString("敌人的数量：" + tList.size(), 10, 80);
        g.setColor(c);
        mainTank.paint(g);
        for (int i = 0; i < objList.size(); i++) {
            objList.get(i).paint(g);
        }
        for (int i = 0; i < objList.size(); i++) {
            for (int j = 0; j < objList.size(); j++) {
                cc.collide(objList.get(i), objList.get(j));
            }
        }

    }


}
