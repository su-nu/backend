package com.example.backend.entity;


import com.example.backend.appUser.AppUser;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String comment;
    private Date createdAt;
    private Date updatedAt;
    private Integer star;

    @ManyToOne()
    @JoinColumn(name = "APP_USER_id")
    private AppUser appUser;

}
