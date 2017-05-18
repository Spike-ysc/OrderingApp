package com.example.yan.orderingapp;

/**
 * Created by yan on 2017/5/18.
 */

public class MealMessage {
    private int imageId;
    private String foodName;
    private String footMessage;
    private String money;
    public MealMessage(int imageId, String foodName, String footMessage, String money){
        this.imageId = imageId;
        this.foodName = foodName;
        this.footMessage = footMessage;
        this.money = money;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFootMessage() {
        return footMessage;
    }

    public void setFootMessage(String footMessage) {
        this.footMessage = footMessage;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}
