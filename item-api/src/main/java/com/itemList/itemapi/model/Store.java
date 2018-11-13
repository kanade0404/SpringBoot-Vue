package com.itemList.itemapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "stores")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;
    @Column(length = 30, nullable = false)
    private String name;
    @Column(nullable = false)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private List<Item> item;
    @Column(nullable = false)
    private Boolean enabled;
    @Column(nullable = false)
    private Timestamp createdAt;
    @Column(nullable = false)
    private Timestamp updatedAt;

    public  static Store newStore(String name){
        Store store = new Store();
        store.name = name;
        store.enabled = true;
        Date now = new Date();
        store.createdAt = new Timestamp(now.getTime());
        store.updatedAt = new Timestamp(now.getTime());
        return store;
    }
}
