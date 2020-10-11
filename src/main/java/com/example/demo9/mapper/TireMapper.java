package com.example.demo9.mapper;

import com.example.demo9.model.Tire;
import com.example.demo9.model.TireDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import sun.util.resources.cldr.ti.CalendarData_ti_ER;

@Mapper
public interface TireMapper {

    TireDTO tireToTireDTO(Tire tire);

}
