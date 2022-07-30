package com.mashibing.tank;

import com.mashibing.tank.enums.Dir;
import com.mashibing.tank.enums.Group;
import com.mashibing.tank.factory.BigFactory;
import com.mashibing.tank.factory.DefaultFactory;
import com.mashibing.tank.factory.GameFactory;
import com.mashibing.tank.pojo.Tank;
import com.mashibing.tank.singleton.GlobalConfig;
import com.mashibing.tank.util.AudioUtil;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //背景音乐
        new Thread(()->new AudioUtil("audio/war1.wav").loop()).start();
        int tankCount = GlobalConfig.INIT_TANK_COUNT;
        GameFactory gf = new BigFactory();
        TankFrame tf = new TankFrame(gf);
        for (int i = 0; i < tankCount; i++) {
            tf.gettList().add(tf.getGf().createTank(50 + i * 80, 200, Dir.DOWN, Group.BAD, tf));
        }

        while (true) {
            Thread.sleep(50);
            tf.repaint();
        }
    }
}
