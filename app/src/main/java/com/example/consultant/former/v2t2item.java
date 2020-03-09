package com.example.consultant.former;

public class v2t2item {
    private String v2_file;
    private String v2_time;
    private String v2_date;
    private int imageId;

    public v2t2item(String v2_file,String v2_time,String v2_date,int imageId)
    {
        this.v2_file=v2_file;
        this.v2_time=v2_time;
        this.v2_date=v2_date;
        this.imageId=imageId;
    }

    public String getv2_file() {
        return v2_file;
    }

    public void setv2_file(String v2_file) {
        this.v2_file = v2_file;
    }

    public String getv2_time() {
        return v2_time;
    }

    public void setv2_time(String v2_time) {
        this.v2_time = v2_time;
    }
    public String getv2_date() {
        return v2_date;
    }

    public void setv2_date(String v2_date) {
        this.v2_date = v2_date;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
