package org.merso.mersoshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="shops_spec")
@Data
public class ShopsSpec {
        @GeneratedValue(strategy = GenerationType.IDENTITY)//解决了表不存在的问题
        @Id
        @JsonIgnore
        private int id;
        private String spec_no;
        private String spec_name;
        @OneToMany(mappedBy = "shopsSpec")
        private List<ShopsSpecValue> shopsSpecValues;
        @JsonIgnore
        @ManyToMany(mappedBy = "shopsSpecs")
        private List<Shops> shops;

}
