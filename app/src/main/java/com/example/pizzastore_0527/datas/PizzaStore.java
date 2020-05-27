package com.example.pizzastore_0527.datas;

public class PizzaStore {

    private String name;
    private String phoneNum;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getLogoImgUri() {
        return logoImgUri;
    }

    public void setLogoImgUri(String logoImgUri) {
        this.logoImgUri = logoImgUri;
    }

    private String logoImgUri;

    public PizzaStore(String name, String phoneNum, String logoImgUri) {
        this.name = name;
        this.phoneNum = phoneNum;
        this.logoImgUri = logoImgUri;
    }
}
