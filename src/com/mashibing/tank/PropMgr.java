package com.mashibing.tank;


import java.io.IOException;
import java.util.Properties;

public class PropMgr {

    private PropMgr() {
    }

    private static PropMgr propMgr = null;
    private static Properties pro = new Properties();

    static {
        try {
            pro.load(PropMgr.class.getClassLoader().getResourceAsStream("config/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    public static Object getObj(String key) {
        return pro.getProperty(key);
    }

    public static String getStr(String key) {
        return pro.getProperty(key);
    }

    public static int getInt(String key) {
        return Integer.parseInt(getStr(key));
    }



}
