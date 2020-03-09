package com.example.consultant.former;

public class materialitem {
    private String mt_name;
    private String introduce;
    private String dld;
    private String mt_detail;

    public materialitem(String mt_name,String introduce,String dld,String mt_detail)
    {
        this.mt_name=mt_name;
        this.introduce=introduce;
        this.dld=dld;
        this.mt_detail=mt_detail;

    }

    public String getmt_name() {
        return mt_name;
    }

    public void setmt_name(String mt_name) {
        this.mt_name=mt_name;
    }

    public String getintroduce() {
        return introduce;
    }

    public void setintroduce(String introduce) {
        this.introduce=introduce;
    }
    public String getdld() {
        return dld;
    }

    public void setdld(String dld) {
        this.dld=dld;
    }
    public String getmt_detail() {
        return mt_detail;
    }

    public void setmt_detail(String mt_detail) {
        this.mt_detail=mt_detail;
    }
}
