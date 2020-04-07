package org.merso.mersoshop.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@IdClass(ShopsPK.class)
@Table(name="shops_sku_spec")
@Data
public class ShopsSkuSpec {


//    @EmbeddedId
//    @ManyToOne
//    @JoinColumn(name = "sku_id")
//    private Shops shops;
//
//
//    @EmbeddedId
//    @ManyToOne
//    @JoinColumn(name = "spec_id")
//    private ShopsSpec shopsSpec;
//@GeneratedValue(strategy = GenerationType.IDENTITY)//解决了表不存在的问题
//@Id
//private int id;

      @Id
      private int skuId;

     @Id
     private int specId;


//    @Override
//    public String toString() {
//        return "ShopsSkuSpec{" +
//                "shops=" + shops +
//                ", shopsSpec=" + shopsSpec +
//                '}';
//    }

    public ShopsSkuSpec() {
        super();
    }

    public ShopsSkuSpec(int skuId,int specId) {
        super();
        this.skuId = skuId;
        this.specId = specId;
    }
}
