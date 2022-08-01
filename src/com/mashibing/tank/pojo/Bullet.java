package com.mashibing.tank.pojo;

import com.mashibing.tank.TankFrame;
import com.mashibing.tank.enums.Dir;
import com.mashibing.tank.enums.Group;
import com.mashibing.tank.pojo.base.BaseBullet;
import com.mashibing.tank.singleton.GlobalConfig;
import com.mashibing.tank.singleton.ResMgr;

import java.awt.*;

public class Bullet extends BaseBullet {


    public Bullet(int x, int y, Dir dir, Group group) {
        super(x, y, dir, group);
    }


    public void paint(Graphics g) {
        switch (dir) {
            case LEFT:
                g.drawImage(ResMgr.bulletL_B, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResMgr.bulletR_B, x, y, null);
                break;
            case UP:
                g.drawImage(ResMgr.bulletU_B, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResMgr.bulletD_B, x, y, null);
                break;
            default:
                break;
        }
        move();
    }

    public void move() {
        if(suspending) return;
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
            die();
            return;
        }
        rect.setLocation(x,y);
    }


}

