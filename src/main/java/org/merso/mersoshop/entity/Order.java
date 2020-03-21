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
    @Column(length = 50)
    private int oid;
    @Column(length = 255)
    private String username;
    @Column(length = 50)
    private int sid;

    @Column(length = 50)
    private int count;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp data;


}
