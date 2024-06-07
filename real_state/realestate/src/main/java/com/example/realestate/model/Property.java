package com.example.realestate.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "property")
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;

    private Integer room;
    private Integer price;
    private String description;
    private String image;

    @ManyToOne
    @JoinColumn(name = "lid", nullable = false)
    private Location location;

    @ManyToOne
    @JoinColumn(name = "cid", nullable = false)
    private Category category;
}
