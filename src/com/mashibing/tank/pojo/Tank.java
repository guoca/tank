package com.mashibing.tank.pojo;

import com.mashibing.tank.*;
import com.mashibing.tank.enums.Dir;
import com.mashibing.tank.enums.Group;
import com.mashibing.tank.pojo.base.BaseTank;
import com.mashibing.tank.singleton.GlobalConfig;
import com.mashibing.tank.singleton.ResMgr;
import com.mashibing.tank.strategy.FireStrategy;

import java.awt.*;

public class Tank extends BaseTank {


    public Tank(int x, int y, Dir dir, Group group, GameModel gm) {
        this.x = x;
        this.y = y;
        super.dir = dir;
        this.gm = gm;
        this.group = group;
        String fsName = GlobalConfig.BAD_TANK_FIRE_STRATEGY;
        if (this.group == Group.GOOD) {
            fsName = GlobalConfig.GOOD_TANK_FIRE_STRATEGY;
        }
        try {
            this.fs = (FireStrategy) Class.forName(fsName).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    public void paint(Graphics g) {
        if (!living) gm.gettList().remove(this);
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

}
