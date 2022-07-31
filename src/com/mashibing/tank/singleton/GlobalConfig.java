package com.mashibing.tank.singleton;

public class GlobalConfig {

    public static final int BULLET_WIDTH = ResMgr.bulletU_B.getWidth();
    public static final int BULLET_HEIGHT = ResMgr.bulletU_B.getHeight();
    public static final int TANK_WIDTH = ResMgr.gTankU.getWidth();
    public static final int TANK_HEIGHT = ResMgr.gTankU.getHeight();
    public static final int EXPOLDE_WIDTH = ResMgr.explodeArr[0].getWidth();
    public static final int EXPOLDE_HEIGHT = ResMgr.explodeArr[0].getHeight();
    private static final ConfigMgr configMgr = ConfigMgr.getInstance();
    public static final int GAME_WIDTH = configMgr.getInt("gameWidth");
    public static final int GAME_HEIGHT = configMgr.getInt("gameHeight");
    public static final int INIT_TANK_COUNT = configMgr.getInt("initTankCount");
    public static final int TANK_SPEED = configMgr.getInt("tankSpeed");
    public static final int BULLET_SPEED = configMgr.getInt("bulletSpeed");
    public static final String GOOD_TANK_FIRE_STRATEGY = configMgr.getStr("goodTankFireStrategy");
    public static final String BAD_TANK_FIRE_STRATEGY = configMgr.getStr("badTankFireStrategy");
    public static final String COLLIDERS = configMgr.getStr("colliders");
    private GlobalConfig() {
    }
}
