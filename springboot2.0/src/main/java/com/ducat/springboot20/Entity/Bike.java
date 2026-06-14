package com.ducat.springboot20.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Bike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//automatically id
    private int id;
    private String bikeModel;
    private String bikeName;
    private String color;
    private double price;
    @ManyToOne
    @JoinColumn(name="ownerId")
    private Owner owner;
    
}
