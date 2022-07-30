package com.mashibing.tank;

import java.awt.*;
import java.util.Random;

public class Tank {
    private int x = 200, y = 200;
    private Dir dir = Dir.DOWN;
    private static final int SPEED = PropMgr.getInstance().getInt(KeyConstant.TANK_SPEED);
    public static final int WIDTH = ResMgr.bTankD.getWidth();
    public static final int HEIGHT = ResMgr.bTankD.getHeight();
    public static final Random RANDOM = new Random();

    private boolean living = true;
    private boolean moving = false;
    private Group group = Group.BAD;
    private TankFrame tf = null;
    private Rectangle rect = new Rectangle(x, y, WIDTH, HEIGHT);


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
                g.drawImage(this.group == Group.BAD ? ResMgr.bTankL : ResMgr.gTankL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(this.group == Group.BAD ? ResMgr.bTankR : ResMgr.gTankR, x, y, null);
                break;
            case UP:
                g.drawImage(this.group == Group.BAD ? ResMgr.bTankU : ResMgr.gTankU, x, y, null);
                break;
            case DOWN:
                g.drawImage(this.group == Group.BAD ? ResMgr.bTankD : ResMgr.gTankD, x, y, null);
                break;
            default:
                break;
        }

        move();
    }

    /**
     * 开火
     */
    public void fire() {
        int bx = this.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int by = this.y + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        tf.bList.add(new Bullet(bx, by, dir, group, tf));
        if (this.group == Group.GOOD) new Thread(() -> new Audio("audio/tank_fire.wav").play()).start();

    }

    /**
     * 获取坦克坐标
     *
     * @return
     */
    public Rectangle getRect() {
        return this.rect;
    }

    private void move() {
        if (!isMoving() && group == Group.GOOD) {
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
        if (this.group == Group.BAD && RANDOM.nextInt(100) > 95) fire();
        if (this.group == Group.BAD && RANDOM.nextInt(100) > 95) randomChangeDir(dir);
        boundsCheck();
        rect.x = x;
        rect.y = y;
    }

    /**
     * 边界检查
     */
    private void boundsCheck() {
        boolean needChangeDir = false;
        if (x < 5) {
            x = 5 + SPEED;
            needChangeDir = true;
        }
        if (y < 30) {
            y = 30 + SPEED;
            needChangeDir = true;
        }
        if (x > TankFrame.GAME_WIDTH - Tank.WIDTH - 5) {
            x = TankFrame.GAME_WIDTH - Tank.WIDTH - (5 + SPEED);
            needChangeDir = true;
        }
        if (y > TankFrame.GAME_HEIGHT - Tank.HEIGHT - 5) {
            y = TankFrame.GAME_HEIGHT - Tank.HEIGHT - (5 + SPEED);
            needChangeDir = true;
        }
        if (needChangeDir) {
            randomChangeDir(dir);
        }
    }

    /**
     * 随机转向
     *
     * @param sDir
     */
    private void randomChangeDir(Dir sDir) {
        int i = RANDOM.nextInt(4);
        if (sDir != null) {
            int ordinal = sDir.ordinal();
            while (ordinal != i) {
                break;
            }
        }
        this.dir = Dir.values()[i];
    }

    public void die() {
        this.living = false;
    }
}
