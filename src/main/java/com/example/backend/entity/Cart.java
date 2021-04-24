package com.example.backend.entity;


import com.example.backend.appUser.AppUser;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "CART")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date createdAt;

    @OneToMany(mappedBy = "cart")
    private Set<Item> items;

    @ManyToOne()
    @JoinColumn(name = "APP_USER_id")
    private AppUser appUser;
}
