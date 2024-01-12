package com.ltp.workbook;

public class Movie {
    private String name;
    private String something;
    private String rate;

    public Movie(String name, String something, String rate) {
        this.name = name;
        this.something = something;
        this.rate = rate;
    }

    public Movie() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSomething() {
        return something;
    }

    public void setSomething(String something) {
        this.something = something;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }
}
