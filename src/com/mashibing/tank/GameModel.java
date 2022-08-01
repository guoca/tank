package com.mashibing.tank;

import com.mashibing.tank.chain.ColliderChain;
import com.mashibing.tank.decorator.RectDecorator;
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

    private static final GameModel GM = new GameModel();

    static {
        GM.init();
    }

    ColliderChain cc = new ColliderChain();
    private final GameFactory gf = new DefaultFactory();
    private BaseTank mainTank;
    private List<BaseGameObject> objList = new ArrayList<>();


    private GameModel() {

    }

    public static GameModel getInstance() {
        return GM;
    }

    private void init() {
        //初始化主坦克
        mainTank = gf.createTank(200, 400, Dir.UP, Group.GOOD);
        int tankCount = GlobalConfig.INIT_TANK_COUNT;
        //初始化敌方坦克
        for (int i = 0; i < tankCount; i++) {
            GM.add(gf.createTank(50 + i * 80, 200, Dir.DOWN, Group.BAD));
        }
        //初始化墙体
        GM.add(new RectDecorator(new Wall(150, 150, 200, 50)));
        GM.add(new Wall(550, 150, 200, 50));
        GM.add(new Wall(300, 300, 50, 200));
        GM.add(new Wall(550, 300, 50, 200));

    }



    public GameFactory getGf() {
        return gf;
    }


    public void add(BaseGameObject obj) {
        this.objList.add(obj);
    }

    public void remove(BaseGameObject obj) {
        this.objList.remove(obj);
    }

    public BaseTank getMainTank() {
        return mainTank;
    }

    public void setMainTank(BaseTank mainTank) {
        this.mainTank = mainTank;
    }

    public List<BaseGameObject> getObjList() {
        return objList;
    }

    public void setObjList(List<BaseGameObject> objList) {
        this.objList = objList;
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
