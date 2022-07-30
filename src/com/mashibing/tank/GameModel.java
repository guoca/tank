package com.mashibing.tank;

import com.mashibing.tank.cor.ColliderChain;
import com.mashibing.tank.enums.Dir;
import com.mashibing.tank.enums.Group;
import com.mashibing.tank.factory.DefaultFactory;
import com.mashibing.tank.factory.GameFactory;
import com.mashibing.tank.pojo.Wall;
import com.mashibing.tank.pojo.base.BaseGameObject;
import com.mashibing.tank.pojo.base.BaseTank;
import com.mashibing.tank.singleton.GlobalConfig;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameModel {

    private BaseTank mainTank;
    private GameFactory gf = new DefaultFactory();
    ColliderChain cc = new ColliderChain();

    private static final GameModel GM = new GameModel();

    static {
        GM.init();
    }

    private void init() {
        //初始化主坦克
        mainTank = gf.createTank(200, 400, Dir.DOWN, Group.GOOD);
        int tankCount = GlobalConfig.INIT_TANK_COUNT;
        //初始化敌方坦克
        for (int i = 0; i < tankCount; i++) {
            gf.createTank(50 + i * 80, 200, Dir.DOWN, Group.BAD);
        }
        //初始化墙体
        add(new Wall(150, 150, 200, 50));
        add(new Wall(550, 150, 200, 50));
        add(new Wall(300, 300, 50, 200));
        add(new Wall(550, 300, 50, 200));

    }


    private GameModel() {

    }

    public static GameModel getInstance() {
        return GM;
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
