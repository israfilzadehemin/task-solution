package com.task.helmestask.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Subcategory extends Selection {

    @OneToMany(mappedBy = "subcategory")
    private List<Product> products;

    @ManyToOne
//    @JoinTable(name = "rel_subcategory_category",
//            joinColumns = {@JoinColumn(name = "subcategory_id", referencedColumnName = "id")},
//            inverseJoinColumns = {@JoinColumn(name = "category_id", referencedColumnName = "id")})
    private Category category;

}
