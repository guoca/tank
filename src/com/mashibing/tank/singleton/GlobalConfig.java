package com.mashibing.tank.singleton;

public class GlobalConfig {

    private GlobalConfig() {
    }

    private static ConfigMgr configMgr = ConfigMgr.getInstance();

    public static final int GAME_WIDTH = configMgr.getInt("gameWidth");
    public static final int GAME_HEIGHT = configMgr.getInt("gameHeight");
    public static final int INIT_TANK_COUNT = configMgr.getInt("initTankCount");
    public static final int TANK_SPEED = configMgr.getInt("tankSpeed");
    public static final int BULLET_SPEED = configMgr.getInt("bulletSpeed");
    public static final String GOOD_TANK_FIRE_STRATEGY = configMgr.getStr("goodTankFireStrategy");
    public static final String BAD_TANK_FIRE_STRATEGY = configMgr.getStr("badTankFireStrategy");
    public static final String COLLIDERS = configMgr.getStr("colliders");
}
