package com.mashibing.tank;

public class GlobalConfig {

    private GlobalConfig() {
    }

    private static PropMgr propMgr = PropMgr.getInstance();

    public static final int GAME_WIDTH = propMgr.getInt("gameWidth");
    public static final int GAME_HEIGHT = propMgr.getInt("gameHeight");
    public static final int INIT_TANK_COUNT = propMgr.getInt("initTankCount");
    public static final int TANK_SPEED = propMgr.getInt("tankSpeed");
    public static final int BULLET_SPEED = propMgr.getInt("bulletSpeed");
    public static final String GOOD_TANK_FIRE_STRATEGY = propMgr.getStr("goodTankFireStrategy");
    public static final String BAD_TANK_FIRE_STRATEGY = propMgr.getStr("badTankFireStrategy");
}
