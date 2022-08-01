package com.mashibing.tank.observer;

import java.util.EventObject;

/**
 * 坦克开火事件
 */
public class TankFireEvent extends EventObject {
    private Object arg;

    public TankFireEvent(Object source, Object arg) {
        super(source);
        this.arg = arg;
    }

    public Object getArg() {
        return arg;
    }
}
