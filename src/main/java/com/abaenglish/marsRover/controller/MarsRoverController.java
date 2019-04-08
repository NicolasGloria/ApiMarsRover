package com.abaenglish.marsRover.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abaenglish.marsRover.services.MarsRoverService;
import com.abaenglish.marsRover.utils.DirectionEnum;

@RestController
public class MarsRoverController {

	@Autowired
	MarsRoverService marsRoverService;
	
	@RequestMapping("/")
	public String index() {
		return "I'm Rover";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/status", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getStatus() {
		return new ResponseEntity<>(marsRoverService.getStatus(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/text", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getText() {
		return new ResponseEntity<>(marsRoverService.getText(), HttpStatus.OK);
	}
  
	@RequestMapping(method = RequestMethod.POST, value = "/move", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> moveRover(@RequestParam(value = "direction", required = true) String direction, @RequestParam(value = "distanceMeters", required = true) Integer distanceMeters) {
		if(DirectionEnum.isMember(direction)) {
			return new ResponseEntity<>(marsRoverService.moveRover(DirectionEnum.forName(direction), distanceMeters), HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Direction possible values: right/left/front/back", HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/standStillCharging", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> standStillCharging() {
		return new ResponseEntity<>(marsRoverService.standStillCharging(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/ultraFastCharge", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> ultraFastCharge() {
		return new ResponseEntity<>(marsRoverService.ultraFastCharge(), HttpStatus.OK);
	}
}
