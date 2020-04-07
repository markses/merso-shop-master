package org.merso.mersoshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="shops_spec")
@Data
public class ShopsSpec implements Serializable {

        private static final long serialVersionUID = -2249032276321918140L;


        @Override
        public String toString() {
                return "ShopsSpec{" +
                        "id=" + id +
                        ", spec_no='" + spec_no + '\'' +
                        ", spec_name='" + spec_name + '\'' +
                        '}';
        }

        @GeneratedValue(strategy = GenerationType.IDENTITY)//解决了表不存在的问题
        @Id
        @JsonIgnore
        private int id;
        private String spec_no;
        private String spec_name;
//        @OneToMany(mappedBy = "shopsSpec")
//        private List<ShopsSpecValue> shopsSpecValues;



        //        @JsonIgnore
//        @ManyToMany(mappedBy = "shopsSpecs")
//        private List<Shops> shops;








}
