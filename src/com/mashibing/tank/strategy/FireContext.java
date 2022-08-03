package com.mashibing.tank.strategy;

import com.mashibing.tank.pojo.base.BaseTank;

import java.util.HashMap;
import java.util.Map;

/**
 * 开火上下文对象
 */
public class FireContext {

    private static final FireContext FC = new FireContext();

    private FireContext() {
    }

    public static FireContext getInstance() {
        return FC;
    }

    private static Map<FireStrategyEnum, FireStrategy> fsMap = new HashMap();

    static {
        for (FireStrategyEnum fes :
                FireStrategyEnum.values()) {
            fsMap.put(fes, fes.getFs());
        }

    }

    public void fire(BaseTank t, FireStrategyEnum fse) {
        FireStrategy fs = fsMap.get(fse);
        fs.fire(t);
    }
}
