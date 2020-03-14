package org.merso.mersoshop.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="login_user")
@Data
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)//解决了表不存在的问题
    @Id
    @Column(length = 32)
    private int id;
    @Column(length = 255)
    private String account;
    @Column(length = 255)
    private String username;
    @Column(length = 255)
    private String password;
//    private String name;
//    private String code;
//    private Boolean allowed;
//    private Boolean isManager;
    @Column(length = 255)
    private String email;
    @Column(length = 64)
    private String code;
}