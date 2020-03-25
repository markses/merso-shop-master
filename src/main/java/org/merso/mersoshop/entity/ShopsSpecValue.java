package org.merso.mersoshop.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="shops_spec_value")
@Data
public class ShopsSpecValue {
    @GeneratedValue(strategy = GenerationType.IDENTITY)//解决了表不存在的问题
    @Id
    private int id;
    private  String spec_value;
    @ManyToOne
    @JoinColumn(name = "spec_id")
    private ShopsSpec shopsSpec;
}