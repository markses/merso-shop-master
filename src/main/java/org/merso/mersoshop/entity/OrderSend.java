package org.merso.mersoshop.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="orders_send")
@Data
public class OrderSend {
    @GeneratedValue(strategy = GenerationType.IDENTITY)//解决了表不存在的问题
    @Id
    private int id;

    @JoinColumn(name = "order_no")
    private String  order_no;
    private String name;
    private String address;
    private int iphone;
    private int postal_code;
    private String courier_company;
    private String courer_no;
    private Boolean send_status;
}
