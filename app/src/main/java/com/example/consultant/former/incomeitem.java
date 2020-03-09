package com.example.consultant.former;

public class incomeitem {
    private String psy_income;
    private String mode;
    private String in_date;
    private String come;

    public incomeitem(String psy_income,String mode,String in_date,String come)
    {
        this.psy_income=psy_income;
        this.mode=mode;
        this.in_date=in_date;
        this.come=come;

    }

    public String getpsy_income() {
        return psy_income;
    }

    public void setpsy_income(String psy_income) {
        this.psy_income=psy_income;
    }

    public String getmode() {
        return mode;
    }

    public void setmode(String mode) {
        this.mode=mode;
    }
    public String getin_date() {
        return in_date;
    }

    public void setin_date(String in_date) {
        this.in_date=in_date;
    }
    public String getcome() {
        return come;
    }

    public void setcome(String come) {
        this.come=come;
    }
}
