package com.example.demo9.mapper;

import com.example.demo9.model.Car;
import com.example.demo9.model.CarDTO;
import com.example.demo9.model.Tire;
import com.example.demo9.model.TireDTO;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(uses = {TireMapper.class, MotorMapper.class})
public interface CarMapper {

    @Mapping(source = "car", target = "hinta", qualifiedByName = "mapHinta")
    @Mapping(source = "car", target = "renkaidenHinta", qualifiedByName = "mapTiresPrice")
    CarDTO carToCarDto(Car car);

    @Named("mapHinta")
    public static Integer mapHinta(Car car) {
        Integer hinta = car.getPerushinta() + car.getLisahinta();
        return hinta;
    }

    @Named("mapTiresPrice")
    public static Integer mapTiresPrice(Car car) {
        return car.getRenkaat().stream().map(i -> i.getHinta()).mapToInt(Integer::intValue).sum();
    }

    List<TireDTO> tiresToTiresDTO(List<Tire> tires);

}

