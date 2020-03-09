package com.example.consultant.former;

public class gz_user {
    private String userName;
    private String latestMsg;
    private int imageId;

    public gz_user(String userName,String latestMsg,int imageId)
    {
        this.userName=userName;
        this.latestMsg=latestMsg;
        this.imageId=imageId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLatestMsg() {
        return latestMsg;
    }

    public void setLatestMsg(String latestMsg) {
        this.latestMsg = latestMsg;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
