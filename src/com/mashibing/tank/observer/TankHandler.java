package com.mashibing.tank.observer;

/**
 * 坦克销毁处理者
 */
public class TankHandler extends TankObserver {
    @Override
    public void actionOnDie(TankFireEvent e) {
        System.out.println("坦克【" + e.getSource() + "】说：" + e.getArg());
    }


}
