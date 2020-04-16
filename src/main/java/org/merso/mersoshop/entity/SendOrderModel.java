package org.merso.mersoshop.entity;

import lombok.Data;

@Data
public class SendOrderModel {

    private String order_no;
    private String name;
    private String address;
    private int iphone;
    private int postal_code;



    public SendOrderModel(String name,String address, int iphone,int postal_code,String order_no){
        this.name = name;
        this.address = address;
        this.postal_code = postal_code;
        this.iphone = iphone;
        this.order_no = order_no;


    }
    public SendOrderModel(){

    }
}
