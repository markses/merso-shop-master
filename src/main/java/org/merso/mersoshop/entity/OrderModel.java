package org.merso.mersoshop.entity;

import lombok.Data;

@Data
public class OrderModel {
    private String sku_url;
    private String sku_name;
    private String color;
    private String size;

    public OrderModel(String sku_url,String sku_name, String color,String size){
  this.sku_url = sku_url;
  this.sku_name = sku_name;
  this.color = color;
  this.size = size;
    }
  public OrderModel(){

  }
}
