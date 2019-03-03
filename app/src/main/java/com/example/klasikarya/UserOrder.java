package com.example.klasikarya;

public class UserOrder {

    public String companyName;
    public String phone;
    public String socialMedia;
    public String product;

    public UserOrder(String companyName, String phone, String socialMedia, String product){
        this.companyName = companyName;
        this.phone = phone;
        this.product = product;
        this.socialMedia = socialMedia;
    }
}
