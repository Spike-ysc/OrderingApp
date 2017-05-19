package com.example.yan.orderingapp;

/**
 * Created by yan on 2017/5/19.
 */

public class AllMsg {
    private static int allTime = 0;
    private static int num = -1;

    public static int getNum() {
        return num;
    }

    public static void setNum(int num) {
        AllMsg.num = num;
    }

    public static int getAllTime() {
        return allTime;
    }

    public static void setAllTime(int allTime) {
        AllMsg.allTime = allTime;
    }
}
