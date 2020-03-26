package org.merso.mersoshop.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="user_info")
@Data
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String province;
    private String address;
    private String city;
    private String sex;
    private String delivery;
    private int iphone;
    private String date;
//    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account")
    private String account;

    public UserInfo(){
        super();
    }
}
