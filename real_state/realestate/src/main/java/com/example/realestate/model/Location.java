package com.example.realestate.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer lid;

    @Column(unique = true) // Adding unique constraint to the city field
    private String city;

    @JsonBackReference
    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private List<Property> properties;
}
