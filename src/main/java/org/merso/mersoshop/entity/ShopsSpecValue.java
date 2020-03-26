package org.merso.mersoshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="shops_spec_value")
@Data
public class ShopsSpecValue {
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)//解决了表不存在的问题
    @Id
    private int id;
    private  String spec_value;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "spec_id")
    private ShopsSpec shopsSpec;
}