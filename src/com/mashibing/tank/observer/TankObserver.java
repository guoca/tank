package com.mashibing.tank.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * 坦克销毁观察者
 */
public abstract class TankObserver implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        TankFireEvent e = new TankFireEvent(o, arg);
        actionOnDie(e);
    }

    abstract void actionOnDie(TankFireEvent e);
}
