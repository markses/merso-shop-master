package org.merso.mersoshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="shops_category")
@Data
public class ShopsCategory {

    @GeneratedValue(strategy = GenerationType.IDENTITY)//解决了表不存在的问题
    @Id
    private int id;
    private String category_name;

//    @OneToMany(mappedBy = "shopsCategory",fetch = FetchType.LAZY)
//    private List<Shops> shopsList;

}