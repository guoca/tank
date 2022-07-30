package com.mashibing.tank.cor;

import com.mashibing.tank.pojo.base.BaseGameObject;
import com.mashibing.tank.singleton.ConfigMgr;
import com.mashibing.tank.singleton.GlobalConfig;

import java.util.ArrayList;
import java.util.List;

public class ColliderChain implements Collider {
    private List<Collider> cList = new ArrayList<>();

    public ColliderChain() {
        String colliders = GlobalConfig.COLLIDERS;
        if(colliders != null && !"".equals(colliders)){
            String[] collideStrArr = colliders.split(",");
            for (String collideStr : collideStrArr) {
                try {
                    Collider c = (Collider) Class.forName(collideStr).newInstance();
                    cList.add(c);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void add(Collider c) {
        cList.add(c);
    }

    @Override
    public boolean collide(BaseGameObject o1, BaseGameObject o2) {
        for (int i = 0; i < cList.size(); i++) {
            if (!cList.get(i).collide(o1, o2)) {
                return false;
            }
        }
        return true;
    }
}
