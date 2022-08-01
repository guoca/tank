package com.mashibing.tank.enums;

public enum Dir {
    LEFT, UP, RIGHT, DOWN;

    public String getDesc() {
        String dirName;
        switch (this) {
            case UP:
                dirName = "上";
                break;
            case DOWN:
                dirName = "下";
                break;
            case LEFT:
                dirName = "左";
                break;
            case RIGHT:
                dirName = "右";
                break;
            default:
                dirName = "";
                break;

        }
        return dirName;

    }
    }
