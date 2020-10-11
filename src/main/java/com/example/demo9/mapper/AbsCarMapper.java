package com.example.demo9.mapper;

import com.example.demo9.model.Car;
import com.example.demo9.model.CarDTO;
import com.example.demo9.model.Tire;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper
public abstract  class AbsCarMapper {

    @Mapping(target = "renkaidenHinta", source = "renkaat")
    @Mapping(target = "hinta", source = "car")
    public abstract CarDTO map(Car car);

    public Integer mapHinta(Car car) {
        Integer hinta = car.getPerushinta() + car.getLisahinta();
        return hinta;
    }

    public Integer mapRenkaidenHinta(List<Tire> renkaat) {
        return renkaat.stream().map(i -> i.getHinta()).mapToInt(Integer::intValue).sum();
    }

}


