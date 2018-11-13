package com.itemList.itemapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "categories")
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;
    @Column(length = 20, nullable = false)
    private String name;
    @Column(nullable = false)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private List<Item> item;
    @Column(nullable = false)
    private Boolean enabled;
    @Column(nullable = false)
    private Timestamp createdAt;
    @Column(nullable = false)
    private Date updatedAt;
    public static Category newCategory(String name){
        Category category = new Category();
        category.name = name;
        category.enabled = true;
        Date now = new Date();
        category.createdAt = new Timestamp(now.getTime());
        category.updatedAt = new Timestamp(now.getTime());
        return category;
    }
}
