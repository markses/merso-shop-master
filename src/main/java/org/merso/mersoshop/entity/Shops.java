package org.merso.mersoshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javafx.scene.transform.Scale;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.List;

@Entity
@Table(name="shops_sku")
@Data
public class Shops implements Serializable{
    private static final long serialVersionUID = 2272686128272973029L;

    @GeneratedValue(strategy = GenerationType.IDENTITY)//解决了表不存在的问题
    @Id

    private int id;
    private String sku_no;
    private String sku_name;
    private String sku_details;
    private int stock;
    private String sku_url;
    private Float price;
    private Float low_price;
    private Boolean is_put;
    private Boolean isprefer;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "category_id") //(cascade=CascadeType.ALL)//People是关系的维护端
    private ShopsCategory shopsCategory;

//    @JsonIgnore //忽略不传给前台的属性
//    @ManyToMany
//    @JoinTable(name = "shops_sku_spec",
//            joinColumns = @JoinColumn(name = "sku_id",referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "spec_id", referencedColumnName = "id"))
//    private List<ShopsSpec> shopsSpecs;



    @Override
    public String toString() {
        return "Shops{" +
                "id=" + id +
                ", sku_no='" + sku_no + '\'' +
                ", sku_name='" + sku_name + '\'' +
                ", sku_details='" + sku_details + '\'' +
                ", stock=" + stock +
                ", sku_url='" + sku_url + '\'' +
                ", price=" + price +
                ", low_price=" + low_price +
                ", shopsCategory=" + shopsCategory +
                '}';
    }



}
