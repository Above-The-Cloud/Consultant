package com.example.consultant;

public class Message {
    private String userName;
    private String latestMsg;

    private int imageId;
    private String time;

    public Message(String userName, String latestMsg, int imageId, String time) {
        this.userName = userName;
        this.latestMsg = latestMsg;
        this.imageId = imageId;
        this.time = time;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


}
