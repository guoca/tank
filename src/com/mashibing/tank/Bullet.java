package com.mashibing.tank;

import java.awt.*;

public class Bullet {
    private static final int SPEED = 5;
    public static final int WIDTH = ResMgr.bulletD.getWidth();
    public static final int HEIGHT = ResMgr.bulletD.getHeight();
    private int x, y;
    private Dir dir;
    private boolean living = true;
    private Group group = Group.BAD;
    private TankFrame tf = null;

    public Bullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
        this.group = group;
    }

    public void paint(Graphics g) {
        if (!living) {
            tf.bList.remove(this);
        }
        switch (dir) {
            case LEFT:
                g.drawImage(ResMgr.bulletL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResMgr.bulletR, x, y, null);
                break;
            case UP:
                g.drawImage(ResMgr.bulletU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResMgr.bulletD, x, y, null);
                break;
            default:
                break;
        }
        move();
    }

    private void move() {
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            default:
                break;
        }
        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) living = false;
    }

    /**
     * 碰撞
     *
     * @param t
     */
    public void collideWith(Tank t) {
        if (this.group == t.getGroup()) return;
        if (this.getRect().intersects(t.getRect())) {
            t.die();
            this.die();
            tf.eList.add(new Expolde(x-Expolde.WIDTH/2,y-Expolde.HEIGHT/2,tf));
        }
    }

    /**
     * 获取子弹坐标
     *
     * @return
     */
    public Rectangle getRect() {
        return new Rectangle(this.x, this.y, this.WIDTH, this.HEIGHT);
    }

    private void die() {
        this.living = false;
    }
}

