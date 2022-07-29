package com.mashibing.tank;

import java.awt.*;
import java.rmi.Remote;

public class Tank {
    private int x = 200, y = 200;
    private Dir dir = Dir.DOWN;
    private static final int SPEED = 10;
    public static final int WIDTH = ResMgr.tankD.getWidth();
    public static final int HEIGHT = ResMgr.tankD.getHeight();

    private boolean living = true;
    private boolean moving = false;
    private Group group = Group.BAD;
    private TankFrame tf = null;


    public Tank(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
        this.group = group;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }


    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public void paint(Graphics g) {
        if (!living) tf.tList.remove(this);
        switch (dir) {
            case LEFT:
                g.drawImage(ResMgr.tankL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResMgr.tankR, x, y, null);
                break;
            case UP:
                g.drawImage(ResMgr.tankU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResMgr.tankD, x, y, null);
                break;
            default:
                break;
        }

        move();
    }

    public void fire() {
        int bx = this.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int by = this.y + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        tf.bList.add(new Bullet(bx, by, dir, group, tf));
    }

    /**
     * 获取坦克坐标
     *
     * @return
     */
    public Rectangle getRect() {
        return new Rectangle(this.x, this.y, this.WIDTH, this.HEIGHT);
    }

    private void move() {
        if (!isMoving()) {
            return;
        }
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
    }

    public void die() {
        this.living = false;
    }
}
