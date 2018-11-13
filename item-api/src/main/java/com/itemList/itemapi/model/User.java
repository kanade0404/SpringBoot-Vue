package com.itemList.itemapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;
    @Column(length = 50, nullable = false)
    private String username;
    @Column(length = 70, nullable = false)
    private String email;
    @Column(length = 50, nullable = false)
    private String password;
    @Column
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Item> item;
    @Column(nullable = false)
    private Boolean enabled;
    @Column(nullable = false)
    private Timestamp createdAt;
    @Column(nullable = false)
    private Timestamp updatedAt;
    public User(String username, String password, String email){
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
