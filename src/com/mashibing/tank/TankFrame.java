package com.mashibing.tank;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class TankFrame extends Frame {

    public static final int GAME_WIDTH = 1080;
    public static final int GAME_HEIGHT = 960;

    Tank mainTank = new Tank(200, 400, Dir.DOWN, Group.GOOD, this);
    List<Tank> tList = new ArrayList<>();
    List<Bullet> bList = new ArrayList<>();
    List<Expolde> eList = new ArrayList<>();

    public TankFrame() {
        setTitle("tank war");
        setSize(GAME_WIDTH, GAME_HEIGHT);
        setResizable(false);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        addKeyListener(new MyKeyListener());

    }

    Image offScreenImg = null;

    @Override
    public void update(Graphics g) {
        if (offScreenImg == null) {
            offScreenImg = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImg.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImg, 0, 0, null);
    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹的数量：" + bList.size(), 10, 60);
        g.drawString("敌人的数量：" + tList.size(), 10, 80);
        g.setColor(c);
        mainTank.paint(g);
        for (int i = 0; i < bList.size(); i++) {
            bList.get(i).paint(g);
        }
        for (int i = 0; i < tList.size(); i++) {
            tList.get(i).paint(g);
        }
        for (int i = 0; i < eList.size(); i++) {
            eList.get(i).paint(g);
        }
        for (int i = 0; i < bList.size(); i++) {
            Bullet b = bList.get(i);
            for (int j = 0; j < tList.size(); j++) {
                b.collideWith(tList.get(j));
            }
        }



    }

    private class MyKeyListener extends KeyAdapter {
        boolean bL = false;
        boolean bR = false;
        boolean bU = false;
        boolean bD = false;

        @Override
        public void keyReleased(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        private void setMainTankDir() {
            if (!(bL || bR || bU || bD)) {
                mainTank.setMoving(false);
            } else {
                mainTank.setMoving(true);
                if (bL) mainTank.setDir(Dir.LEFT);
                if (bR) mainTank.setDir(Dir.RIGHT);
                if (bU) mainTank.setDir(Dir.UP);
                if (bD) mainTank.setDir(Dir.DOWN);
            }

        }

        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                case KeyEvent.VK_SPACE:
                    mainTank.fire();
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }
    }
}
