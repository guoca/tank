package com.mashibing.tank.flyweight;

import com.mashibing.tank.enums.Dir;
import com.mashibing.tank.enums.Group;
import com.mashibing.tank.pojo.Bullet;
import com.mashibing.tank.pojo.base.BaseBullet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 子弹池
 */
public class BulletPool {

    private BulletPool() {
    }

    private static final BulletPool bp = new BulletPool();

    public static BulletPool getInstance() {
        return bp;
    }

    List<BaseBullet> bList = new ArrayList<>();

    public List<BaseBullet> getbList() {
        return bList;
    }


    public BaseBullet getBullet(int x, int y, Dir dir, Group group) {
        System.out.println("享元模式获取子弹，子弹池大小："+bList.size());
        for (int i = 0; i < bList.size(); i++) {
            BaseBullet b = bList.get(i);
            synchronized (b) {
                if (!b.isLiving()) {
                    b.reset(x, y, dir, group);
                    return b;
                }
            }

        }
        BaseBullet b = new Bullet(x, y, dir, group);
        bList.add(b);
        return b;
    }

    public static void main(String[] args) {

        BulletPool bp = BulletPool.getInstance();
        ;
        new Thread(() -> {
            while (true) {
                List<BaseBullet> bList = bp.getbList();
                for (int i = 0; i < bList.size(); i++) {
                    BaseBullet b = bList.get(i);
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    b.die();
                }
            }

        }).start();
        Random r = new Random();
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(51);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(bp.getBullet(r.nextInt(), r.nextInt(), Dir.values()[r.nextInt(4)], Group.values()[r.nextInt(2)]));
            }
        }).start();

    }
}
