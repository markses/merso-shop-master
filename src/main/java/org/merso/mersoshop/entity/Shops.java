package org.merso.mersoshop.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="shops")
@Data
public class Shops {
    @GeneratedValue(strategy = GenerationType.IDENTITY)//解决了表不存在的问题
    @Id
    @Column(length = 50)
    private int sid;
    @Column(length = 255)
    private String sname;
    @Column(length = 50)
    private Float sprice;
    @Column(length = 255)
    private String surl;
    //    private String name;
//    private String code;
//    private Boolean allowed;
//    private Boolean isManager;
    @Column(length = 50)
    private int stock;
    @Column(length = 1000)
    private String sdetails;
}
