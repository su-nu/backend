package com.example.backend.entity;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;



@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "ITEM")
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long price;
    private Date createdAt;
    private Date updatedAt;


    @ManyToOne()
    @JoinColumn(name = "CART_id")
    private Cart cart;

}
