package com.mashibing.tank.pojo;

import com.mashibing.tank.*;
import com.mashibing.tank.enums.Dir;
import com.mashibing.tank.enums.Group;
import com.mashibing.tank.pojo.base.BaseBullet;
import com.mashibing.tank.pojo.base.BaseTank;
import com.mashibing.tank.singleton.GlobalConfig;
import com.mashibing.tank.singleton.ResMgr;

import java.awt.*;

public class Bullet extends BaseBullet {
    private static final int SPEED = GlobalConfig.BULLET_SPEED;
    public static final int WIDTH = ResMgr.bulletD.getWidth();
    public static final int HEIGHT = ResMgr.bulletD.getHeight();
    private int x, y;
    private Dir dir;
    private Group group;
    private GameModel gm;
    private boolean living = true;
    private Rectangle rect = new Rectangle(x, y, WIDTH, HEIGHT);

    public Bullet(int x, int y, Dir dir, Group group, GameModel gm) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.gm = gm;
        this.group = group;
        gm.getbList().add(this);
    }

    public void paint(Graphics g) {
        if (!living) {
            gm.getbList().remove(this);
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
        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) {
            living = false;
            return;
        }
        rect.x = x;
        rect.y = y;
    }

    /**
     * 碰撞
     *
     * @param t
     */
    public void collideWith(BaseTank t) {
        if (this.group == t.getGroup()) return;
        if (this.getRect().intersects(t.getRect())) {
            t.die();
            this.die();
            int eX = t.getX() + Tank.WIDTH / 2 - Expolde.WIDTH / 2;
            int eY = t.getY() + Tank.HEIGHT / 2 - Expolde.HEIGHT / 2;
            gm.geteList().add(gm.getGf().createExpolde(eX, eY, gm));
        }
    }

    /**
     * 获取子弹坐标
     *
     * @return
     */
    public Rectangle getRect() {
        return this.rect;
    }

    private void die() {
        this.living = false;
    }
}

