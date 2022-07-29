package com.mashibing.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResMgr {

    public static BufferedImage gTankL, gTankR, gTankU, gTankD;
    public static BufferedImage bTankL, bTankR, bTankU, bTankD;
    public static BufferedImage bulletL, bulletR, bulletU, bulletD;
    public static BufferedImage[] explodeArr = new BufferedImage[16];

    static {
        try {
            gTankU = ImageIO.read(ResMgr.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
            gTankL = ImgUtil.rotateImg(gTankU, -90);
            gTankR = ImgUtil.rotateImg(gTankU, 90);
            gTankD = ImgUtil.rotateImg(gTankU, 180);
            bTankU = ImageIO.read(ResMgr.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
            bTankL = ImgUtil.rotateImg(bTankU, -90);
            bTankR = ImgUtil.rotateImg(bTankU, 90);
            bTankD = ImgUtil.rotateImg(bTankU, 180);
            bulletU = ImageIO.read(ResMgr.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));
            bulletL = ImgUtil.rotateImg(bulletU, -90);
            bulletR = ImgUtil.rotateImg(bulletU, 90);
            bulletD = ImgUtil.rotateImg(bulletU, 180);
            for (int i = 0; i < 16; i++) {
                explodeArr[i] = ImageIO.read(ResMgr.class.getClassLoader().getResourceAsStream("images/e" + (i + 1) + ".gif"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
