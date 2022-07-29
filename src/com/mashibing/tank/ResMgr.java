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
            tankL = ImageIO.read(ResMgr.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
            tankR = ImageIO.read(ResMgr.class.getClassLoader().getResourceAsStream("images/tankR.gif"));
            tankU = ImageIO.read(ResMgr.class.getClassLoader().getResourceAsStream("images/tankU.gif"));
            tankD = ImageIO.read(ResMgr.class.getClassLoader().getResourceAsStream("images/tankD.gif"));
            bulletL = ImageIO.read(ResMgr.class.getClassLoader().getResourceAsStream("images/bulletL.gif"));
            bulletR = ImageIO.read(ResMgr.class.getClassLoader().getResourceAsStream("images/bulletR.gif"));
            bulletU = ImageIO.read(ResMgr.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));
            bulletD = ImageIO.read(ResMgr.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
            for (int i = 0; i < 16; i++) {
                explodeArr[i] = ImageIO.read(ResMgr.class.getClassLoader().getResourceAsStream("images/e" + (i + 1) + ".gif"));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
