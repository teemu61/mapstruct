package com.example.demo9;

import com.example.demo9.mapper.AbsCarMapper;
import com.example.demo9.mapper.CarMapper;
import com.example.demo9.model.Car;
import com.example.demo9.model.CarDTO;
import com.example.demo9.model.Motor;
import com.example.demo9.model.Tire;
import com.example.demo9.mapper.TireMapper;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class Demo9ApplicationTests {

	private static final Charset ENCODING_CHARSET = StandardCharsets.UTF_8;

	@Autowired
	public AbsCarMapper absMapper;

	@Autowired
	public CarMapper mapper;

	@Autowired
	public TireMapper tireMapper;

	static Car car;

	@BeforeAll
	static void beforeAll() {
		Tire tire = Tire.builder().hinta(90).vanne("alumiini").build();
		Motor motor = Motor.builder().hinta(70).model("d5").build();
		List<Tire> tireList = Arrays.asList(tire, tire, tire);
		car = Car.builder().lisahinta(10).perushinta(100).merkki("volvo").renkaat(tireList).motor(motor).build();
	}

	@Test
	void name() {
		CarDTO carDTO = absMapper.map(car);
		assertEquals(110, carDTO.getHinta());
		assertEquals("volvo", carDTO.getMerkki());
		assertEquals("alumiini", carDTO.getRenkaat().get(0).getVanne());
		assertEquals(90, carDTO.getRenkaat().get(0).getHinta());
		assertEquals("alumiini", carDTO.getRenkaat().get(2).getVanne());
		assertEquals(90, carDTO.getRenkaat().get(2).getHinta());
		assertEquals("d5", carDTO.getMotor().getModel());
		assertEquals(270, carDTO.getRenkaidenHinta());

	}

	@Ignore
	@Test
	void name2() {
		CarDTO carDTO = mapper.carToCarDto(car);
		assertEquals(110,carDTO.getHinta());
		assertEquals("volvo", carDTO.getMerkki());
		assertEquals("alumiini", carDTO.getRenkaat().get(0).getVanne());
		assertEquals(90, carDTO.getRenkaat().get(0).getHinta());
		assertEquals("d5", carDTO.getMotor().getModel());
		assertEquals(270, carDTO.getRenkaidenHinta());
	}
}
