package com.abaenglish.marsRover.services;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.abaenglish.marsRover.utils.DirectionEnum;
import com.abaenglish.marsRover.utils.MarsRoverUtils;

@Service
public class MarsRoverService {
	
	Integer x = 0;
	Integer y = 0;
	Integer batteryCharge = 100;
	Boolean charging = Boolean.FALSE;

	public String moveRover(DirectionEnum direction, Integer distanceMeters) {
		charging=Boolean.FALSE;
		if (batteryCharge > 0 && batteryCharge >= distanceMeters ){
			switch (direction) {
			case RIGHT:
				x += distanceMeters;
				break;
			case LEFT:
				x -= distanceMeters;
				break;
			case FRONT:
				y += distanceMeters;
				break;
			case BACK:
				y -= distanceMeters;
				break;
			}
			
			batteryCharge -= distanceMeters;
			return this.getStatus();
		}else {
			return "Rover doesn't have enough battery\n"
					+ "The current battery charge: "+batteryCharge+"% and needs "+distanceMeters+"%";
		}
	}
	
	public String standStillCharging() {
		charging=Boolean.TRUE;
		return "Rover is charging";
	}

	public String ultraFastCharge() {
		charging=Boolean.FALSE;
		batteryCharge = 100;
		return this.getStatus();
	}
	
	public String getStatus() {
		return "Current position x: "+x+"m, y: "+y+"m\n"
				+ "Current battery charge: "+batteryCharge+"%";
	}
	
	public String getText() {
		return MarsRoverUtils.getRandomText();
	}
	
	@Scheduled(fixedRate = 2000)
	public void scheduleFixedRateTask() {
	    if(charging && batteryCharge<100) batteryCharge++;
	}

}
