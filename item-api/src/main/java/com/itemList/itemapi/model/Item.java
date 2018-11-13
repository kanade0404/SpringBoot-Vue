package com.itemList.itemapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;
    @Column(length = 50, nullable = false)
    private String name;
    @Column(length = 3, nullable = false)
    private Integer amount;
    @ManyToOne
    private User user;
    @ManyToOne
    private Category category;
    @ManyToOne
    private Store store;
    @Column(nullable = false)
    private Boolean purchased;
    @Column(nullable = false)
    private Boolean enabled;
    @Column(nullable = false)
    private Timestamp createdAt;
    @Column(nullable = false)
    private Timestamp updatedAt;

    public static Item newItem(String name, Integer amount, Long userId, Long storeId, Long categoryId){
        Item item = new Item();
        item.name = name;
        item.amount = amount;
        item.purchased = false;
        Date now = new Date();
        item.createdAt = new Timestamp(now.getTime());
        item.updatedAt = new Timestamp(now.getTime());
        return item;
    }
}
