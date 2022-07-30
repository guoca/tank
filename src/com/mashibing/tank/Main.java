package com.mashibing.tank;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //背景音乐
//        new Thread(()->new Audio("audio/war1.wav").loop()).start();
        int tankCount = PropMgr.getInstance().getInt(KeyConstant.INIT_TANK_COUNT);
        TankFrame tf = new TankFrame();
        for (int i = 0; i < tankCount; i++) {
            tf.tList.add(new Tank(50 + i * 80, 200, Dir.DOWN, Group.BAD, tf));
        }

        while (true) {
            Thread.sleep(50);
            tf.repaint();
        }
    }
}
