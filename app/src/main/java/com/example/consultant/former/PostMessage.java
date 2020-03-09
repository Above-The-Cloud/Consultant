package com.example.consultant.former;

public class PostMessage {
    private String userName;
    private String latestMsg;
    private String path;
    private String content;
    private String time;
    private int imageId;

    public PostMessage(String userName, String content, String path ,String time) {
        this.userName = userName;
        this.content = content;

        this.time = time;
        this.path=path;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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
