package com.example.consultant;

public class PostMessage {
    private String userName;
    private String latestMsg;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private String content;

    private int imageId;
    private String time;

    public PostMessage(String userName, String latestMsg, String content, int imageId, String time) {
        this.userName = userName;
        this.content = content;
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
