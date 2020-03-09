package com.example.consultant.former;

public class alertitem {
    private String c_name;
    private String t_a;
    private String prb;
    private String reservation;

    public alertitem(String c_name,String t_a,String prb,String reservation)
    {
        this.c_name=c_name;
        this.t_a=t_a;
        this.prb=prb;
        this.reservation=reservation;

    }

    public String getc_name() {
        return c_name;
    }

    public void setc_name(String c_name) {
        this.c_name=c_name;
    }

    public String gett_a() {
        return t_a;
    }

    public void sett_a(String t_a) {
        this.t_a=t_a;
    }
    public String getprb() {
        return prb;
    }

    public void setprb(String prb) {
        this.prb=prb;
    }
    public String getreservation() {
        return reservation;
    }

    public void setreservation(String reservation) {
        this.reservation=reservation;
    }
}
