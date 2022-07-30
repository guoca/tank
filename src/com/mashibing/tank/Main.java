package com.mashibing.tank;

import com.mashibing.tank.enums.Dir;
import com.mashibing.tank.enums.Group;
import com.mashibing.tank.factory.DefaultFactory;
import com.mashibing.tank.factory.GameFactory;
import com.mashibing.tank.singleton.GlobalConfig;
import com.mashibing.tank.util.AudioUtil;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //背景音乐
        new Thread(() -> new AudioUtil("audio/war1.wav").loop()).start();
        TankFrame tf = new TankFrame();

        while (true) {
            Thread.sleep(50);
            tf.repaint();
        }
    }
}
