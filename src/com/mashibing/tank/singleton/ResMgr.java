package com.mashibing.tank.singleton;

import com.mashibing.tank.util.ImgUtil;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 资源管理类
 */
public class ResMgr {
    private ResMgr() {
    }

    public static BufferedImage gTankL, gTankR, gTankU, gTankD;
    public static BufferedImage bTankL, bTankR, bTankU, bTankD;
    public static BufferedImage bulletL, bulletR, bulletU, bulletD;
    public static BufferedImage bulletL_B, bulletR_B, bulletU_B, bulletD_B;
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
            bulletU_B = ImageIO.read(ResMgr.class.getClassLoader().getResourceAsStream("images/bulletU.png"));
            bulletL_B = ImgUtil.rotateImg(bulletU_B, -90);
            bulletR_B = ImgUtil.rotateImg(bulletU_B, 90);
            bulletD_B = ImgUtil.rotateImg(bulletU_B, 180);
            for (int i = 0; i < 16; i++) {
                explodeArr[i] = ImageIO.read(ResMgr.class.getClassLoader().getResourceAsStream("images/e" + (i + 1) + ".gif"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
