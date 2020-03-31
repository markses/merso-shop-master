package org.merso.mersoshop.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="orders")
@Data
public class Order {
    @GeneratedValue(strategy = GenerationType.IDENTITY)//解决了表不存在的问题
    @Id
    private int id;
    @JoinColumn(name = "account")
    private String account;
    @JoinColumn(name = "sku_id")
    private int skuId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp date;
    private String color;
    private String size;
    private String orderNo;
    private int count;
    private int order_status;



}
