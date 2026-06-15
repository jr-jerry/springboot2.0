package com.ducat.springboot20.dto;


import lombok.*;

@Getter
@Setter
@Builder
public class BikeDTO {
    private String bikeModel;
    private String bikeName;
    private String color;
    private double price;
}
