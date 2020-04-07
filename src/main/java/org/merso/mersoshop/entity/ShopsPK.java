package org.merso.mersoshop.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class ShopsPK implements Serializable {

    private static final long serialVersionUID = 5488251894364448981L;
     private int skuId;
     private int specId;
}
