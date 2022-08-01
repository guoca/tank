package com.mashibing.tank;

import com.mashibing.tank.enums.Dir;
import com.mashibing.tank.pojo.base.BaseGameObject;
import com.mashibing.tank.pojo.base.BaseTank;
import com.mashibing.tank.singleton.GlobalConfig;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.List;

public class TankFrame extends Frame {
    public static final int GAME_WIDTH = GlobalConfig.GAME_WIDTH;
    public static final int GAME_HEIGHT = GlobalConfig.GAME_HEIGHT;
    Image offScreenImg = null;

    public TankFrame() {
        setTitle("坦克大战");
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
        GameModel.getInstance().paint(g);

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
            BaseTank mainTank = GameModel.getInstance().getMainTank();
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
                    GameModel.getInstance().getMainTank().fire();
                    break;
                case KeyEvent.VK_S:
                    save();
                case KeyEvent.VK_L:
                    load();
                default:
                    break;
            }
            setMainTankDir();
        }

        /**
         * 读档
         */
        private void load() {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("D:/game.data")))) {
                BaseTank mainTank = (BaseTank) ois.readObject();
                List<BaseGameObject> objList = (List<BaseGameObject>) ois.readObject();
                GameModel gm = GameModel.getInstance();
                gm.setMainTank(mainTank);
                gm.setObjList(objList);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }


        }

        /**
         * 存档
         */
        private void save() {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("D:/game.data")))) {
                GameModel gm = GameModel.getInstance();
                BaseTank mainTank = gm.getMainTank();
                List<BaseGameObject> objList = gm.getObjList();
                oos.writeObject(mainTank);
                oos.writeObject(objList);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
