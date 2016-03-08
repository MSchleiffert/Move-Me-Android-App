package com.example.arjen.fblogin.Models;

import java.util.Date;

/**
 * Created by Menno on 8-3-2016.
 */
public class User {
    private String userName;
    private String userMail;
    private Date dateCreated;
    private int pointBalance;
    private Events[] userEvents;


    public User(String userName, String userMail){
        this.userName = userName;
        this.userMail = userMail;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public int getPointBalance() {
        return pointBalance;
    }

    public void addPointBalance(int earnedPoints){

    }

    public void decreasePointBalance(int spendPoints){

    }




}
