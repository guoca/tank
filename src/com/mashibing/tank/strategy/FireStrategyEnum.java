package com.mashibing.tank.strategy;

/**
 * 开火策略枚举
 */
public enum FireStrategyEnum {

    DEFAULT(new DefaultFireStrategy()), FOUR_DIR_FIRE(new FourDirFireStrategy());

    private FireStrategy fs;

    FireStrategyEnum(FireStrategy fs) {
        this.fs = fs;
    }

    public FireStrategy getFs() {
        return fs;
    }

}
