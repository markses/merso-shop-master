package org.merso.mersoshop.entity;

import lombok.Data;

@Data
public class ShopsModel {
    private int id;
    private String sku_no;
    private String sku_name;
    private String sku_details;
    private int stock;
    private String sku_url;
    private Float price;
    private Float low_price;

    public ShopsModel(int id,String sku_no,String sku_name,String sku_details,int stock,String sku_url,Float price,Float low_price){
        this.sku_url = sku_url;
        this.sku_name = sku_name;
        this.id = id;
       this.sku_no = sku_no;
        this.sku_details = sku_details;
        this.stock = stock;
        this.price = price;
        this.low_price = low_price;

    }
    public ShopsModel(){

    }
}
