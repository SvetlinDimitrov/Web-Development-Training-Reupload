package com;

public class HelloEntity {
    private String country;
    private String message;

    public HelloEntity() {
    }

    public HelloEntity(String country, String message) {
        this.country = country;
        this.message = message;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "HelloEntity{" +
                "country='" + country + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
