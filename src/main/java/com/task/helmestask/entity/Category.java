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
public class Category extends Selection {

    @OneToMany(mappedBy = "category")
    private List<Subcategory> subcategories;

    @ManyToOne
    private Sector sector;

}
