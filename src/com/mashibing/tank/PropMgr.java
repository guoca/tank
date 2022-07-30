package com.mashibing.tank;


import java.io.IOException;
import java.util.Properties;

/**
 * 配置管理类
 */
public class PropMgr {

    private static Properties pro = new Properties();

    private PropMgr() {
    }

    private static PropMgr propMgr = new PropMgr();

    static {
        try {
            pro.load(PropMgr.class.getClassLoader().getResourceAsStream("config/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static PropMgr getInstance() {
        return propMgr;
    }

    public String getStr(String key) {
        return pro.getProperty(key);
    }

    public int getInt(String key) {
        return Integer.parseInt(getStr(key));
    }


}
