package com.example.demo9.model;

import java.util.List;
import lombok.Data;

@Data
public class CarDTO {

    private Integer hinta;
    private String merkki;
    private List<Tire> renkaat;
    private Motor motor;
    private Integer renkaidenHinta;

}
