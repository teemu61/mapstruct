package com.example.demo9.model;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Car {
    private Integer perushinta;
    private Integer lisahinta;
    private String merkki;
    private List<Tire> renkaat;
    private Motor motor;

}
