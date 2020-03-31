package org.merso.mersoshop.entity;

import lombok.Data;

@Data
public class OrderModel {
    private String sku_url;
    private String sku_name;
    private String color;
    private String size;
    private String order_no;
    private int id;

    public OrderModel(String sku_url,String sku_name, String color,String size,String order_no,int id){
  this.sku_url = sku_url;
  this.sku_name = sku_name;
  this.color = color;
  this.size = size;
  this.order_no = order_no;
  this.id = id;
    }
  public OrderModel(){

  }
}
