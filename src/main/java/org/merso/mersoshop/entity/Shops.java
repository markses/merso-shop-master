package org.merso.mersoshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="shops_sku")
@Data
public class Shops {
    @GeneratedValue(strategy = GenerationType.IDENTITY)//解决了表不存在的问题
    @Id
    private int id;
    private String sku_no;
    private String sku_name;
    private String sku_details;
    private int stock;
    private Float price;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "category_id") //(cascade=CascadeType.ALL)//People是关系的维护端
    private ShopsCategory shopsCategory;

    @JsonIgnore //忽略不传给前台的属性
    @ManyToMany
    @JoinTable(name = "shops_sku_spec",
            joinColumns = @JoinColumn(name = "sku_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "spec_id", referencedColumnName = "id"))
    private List<ShopsSpec> shopsSpecs;
}
