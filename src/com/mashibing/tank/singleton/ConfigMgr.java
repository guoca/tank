package com.mashibing.tank.singleton;


import java.io.IOException;
import java.util.Properties;

/**
 * 配置管理类
 */
public class ConfigMgr {

    private static Properties pro = new Properties();

    private ConfigMgr() {
    }

    private static ConfigMgr configMgr = new ConfigMgr();

    static {
        try {
            pro.load(ConfigMgr.class.getClassLoader().getResourceAsStream("config/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static ConfigMgr getInstance() {
        return configMgr;
    }

    public String getStr(String key) {
        return pro.getProperty(key);
    }

    public int getInt(String key) {
        return Integer.parseInt(getStr(key));
    }


}
