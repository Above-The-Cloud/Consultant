package com.example.consultant.former;

public class clientitem {
    private String cname;
    private String count;
    private String sta;


    public clientitem(String cname,String count,String sta)
    {
        this.cname=cname;
        this.count=count;
        this.sta=sta;


    }

    public String getcname() {
        return cname;
    }

    public void setcname(String cname) {
        this.cname=cname;
    }

    public String getcount() {
        return count;
    }

    public void setcount(String count) {
        this.count=count;
    }
    public String getsta() {
        return sta;
    }

    public void setsta(String sta) {
        this.sta=sta;
    }

}
