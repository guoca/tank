package com.mashibing.tank;

import com.mashibing.tank.util.AudioUtil;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("1");


        //背景音乐
        new Thread(() -> new AudioUtil("audio/war1.wav").loop()).start();
        TankFrame tf = new TankFrame();
        while (true) {
            Thread.sleep(100);
            tf.repaint();
        }

    }
}
