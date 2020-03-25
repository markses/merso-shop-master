package org.merso.mersoshop.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="user_login")
@Data
public class User {


    //@Column(name = "account")
   // @GeneratedValue(strategy = GenerationType.AUTO)//解决了表不存在的问题
    @Id
    @GeneratedValue(generator = "customUUIDGenerator")
    @GenericGenerator(name = "customUUIDGenerator", strategy = "org.merso.mersoshop.result.CustomUUIDGenerator")
    private String account;
    private String username;
    private String password;
    private String email;
    private String avatar;
    private String code;
}