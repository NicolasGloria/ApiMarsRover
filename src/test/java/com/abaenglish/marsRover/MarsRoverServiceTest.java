package com.abaenglish.marsRover;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.abaenglish.marsRover.services.MarsRoverService;
import com.abaenglish.marsRover.utils.DirectionEnum;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MarsRoverServiceTest {

	@Mock
	MarsRoverService marsRoverService;
	
	@Test
	public void moveRoverRightTest() {
		marsRoverService= new MarsRoverService();
		String result = marsRoverService.moveRover(DirectionEnum.RIGHT,10);
		assertEquals(result, 
				"Current position x: 10m, y: 0m\n"
				+ "Current battery charge: 90%");
	}
	
	@Test
	public void moveRoverLeftTest() {
		marsRoverService= new MarsRoverService();
		String result = marsRoverService.moveRover(DirectionEnum.LEFT,20);
		assertEquals(result, 
				"Current position x: -20m, y: 0m\n"
				+ "Current battery charge: 80%");
	}
	
	@Test
	public void moveRoverFrontTest() {
		marsRoverService= new MarsRoverService();
		String result = marsRoverService.moveRover(DirectionEnum.FRONT,50);
		assertEquals(result, 
				"Current position x: 0m, y: 50m\n"
				+ "Current battery charge: 50%");
	}
	
	@Test
	public void moveRoverBackTest() {
		marsRoverService= new MarsRoverService();
		String result = marsRoverService.moveRover(DirectionEnum.BACK,80);
		assertEquals(result, 
				"Current position x: 0m, y: -80m\n"
				+ "Current battery charge: 20%");
	}
	
	@Test
	public void moveRoverWithoutChargeTest() {
		marsRoverService= new MarsRoverService();
		marsRoverService.moveRover(DirectionEnum.RIGHT,80);
		String result = marsRoverService.moveRover(DirectionEnum.BACK,80);
		assertEquals(result, 
				"Rover doesn't have enough battery\n"
				+ "The current battery charge: 20% and needs 80%");
	}
	
	@Test
	public void ultraFastChargeTest() {
		marsRoverService= new MarsRoverService();
		String result = marsRoverService.moveRover(DirectionEnum.BACK,100);
		assertEquals(result, 
				"Current position x: 0m, y: -100m\n"
				+ "Current battery charge: 0%");
		String result2 = marsRoverService.ultraFastCharge();
		assertEquals(result2, 
				"Current position x: 0m, y: -100m\n"
						+ "Current battery charge: 100%");
	}
	
	@Test
	public void getStatusTest() {
		marsRoverService= new MarsRoverService();
		marsRoverService.moveRover(DirectionEnum.LEFT,20);
		String result = marsRoverService.getStatus();
		assertEquals(result, 
				"Current position x: -20m, y: 0m\n"
				+ "Current battery charge: 80%");
		marsRoverService.moveRover(DirectionEnum.LEFT,20);
		String result2 = marsRoverService.getStatus();
		assertEquals(result2, 
				"Current position x: -40m, y: 0m\n"
				+ "Current battery charge: 60%");
	}
	
	@Test
	public void standStillChargingTest() throws InterruptedException {
		marsRoverService= new MarsRoverService();
		String result = marsRoverService.standStillCharging();
		assertEquals(result, "Rover is charging");
	}
	
}
