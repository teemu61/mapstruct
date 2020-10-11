package com.example.demo9.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Motor {

    private String model;
    private Integer hinta;
}
