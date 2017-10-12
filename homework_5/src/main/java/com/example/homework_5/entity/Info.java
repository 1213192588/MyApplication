package com.example.homework_5.entity;

/**
 * Created by 123456 on 2017/10/9.
 */

public class Info {
    private int head;
    private String name;
    private String phone;
    private boolean hasChecked = false;

    public boolean isHasChecked() {
        return hasChecked;
    }

    public void setHasChecked(boolean hasChecked) {
        this.hasChecked = hasChecked;
    }

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getphone() {
        return phone;
    }

    public void setphone(String phone) {
        this.phone = phone;
    }

    public Info(){

    }

}
