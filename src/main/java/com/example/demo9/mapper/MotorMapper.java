package com.example.demo9.mapper;

import com.example.demo9.model.Motor;
import com.example.demo9.model.MotorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface MotorMapper {

    @Mapping(source="model", target="malli")
    MotorDTO mapMotor(Motor motor);

}
