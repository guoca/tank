package com.mashibing.tank;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * 图片旋转工具类
 */
public class ImgUtil {
    /**
     * 旋转
     *
     * @param bufImg 原图片
     * @param degree 角度
     * @return 新图片
     */
    public static BufferedImage rotateImg(final BufferedImage bufImg, final int degree) {
        int w = bufImg.getWidth();
        int h = bufImg.getHeight();
        int type = bufImg.getColorModel().getTransparency();
        BufferedImage img;
        Graphics2D graphics2D;
        (graphics2D = (img = new BufferedImage(w, h, type)).createGraphics()).setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2D.rotate(Math.toRadians(degree), w / 2, h / 2);
        graphics2D.drawImage(bufImg, 0, 0, null);
        graphics2D.dispose();
        return img;
    }
}
