package com.example.aaradhya.models;


import java.io.Serializable;

public class CartModel implements Serializable {

    String Current_Date;
    String Current_Time;
    String Product_Name;
    String Product_Price;
    int Total_Price;
    String Total_Quantity;

    public CartModel() {
    }



    public String getCurrent_Date() {
        return Current_Date;
    }

    public void setCurrent_Date(String current_Date) {
        Current_Date = current_Date;
    }

    public String getCurrent_Time() {
        return Current_Time;
    }

    public void setCurrent_Time(String current_Time) {
        Current_Time = current_Time;
    }

    public String getProduct_Name() {
        return Product_Name;
    }

    public void setProduct_Name(String product_Name) {
        Product_Name = product_Name;
    }

    public String getProduct_Price() {
        return Product_Price;
    }

    public void setProduct_Price(String product_Price) {
        Product_Price = product_Price;
    }

    public int getTotal_Price() {
        return Total_Price;
    }

    public void setTotal_Price(int total_Price) {
        Total_Price = total_Price;
    }

    public String getTotal_Quantity() {
        return Total_Quantity;
    }

    public void setTotal_Quantity(String total_Quantity) {
        Total_Quantity = total_Quantity;
    }

    public CartModel(String current_Date, String current_Time, String product_Name, String product_Price, int total_Price, String total_Quantity) {
        Current_Date = current_Date;
        Current_Time = current_Time;
        Product_Name = product_Name;
        Product_Price = product_Price;
        Total_Price = total_Price;
        Total_Quantity = total_Quantity;
    }

}
