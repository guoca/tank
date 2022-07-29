package com.mashibing.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResMgr {
    public static BufferedImage tankL, tankR, tankU, tankD;
    public static BufferedImage bulletL, bulletR, bulletU, bulletD;
    public static BufferedImage[] explodeArr = new BufferedImage[16];

    static {
        try {
            tankU = ImageIO.read(ResMgr.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
            tankL = ImgUtil.rotateImg(tankU, -90);
            tankR = ImgUtil.rotateImg(tankU, 90);
            tankD = ImgUtil.rotateImg(tankU, 180);
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
