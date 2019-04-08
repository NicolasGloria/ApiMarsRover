package com.abaenglish.marsRover;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MarsRoverApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(MarsRoverApplication.class, args);
		
	    String[] beanNames = ctx.getBeanDefinitionNames();
	    Arrays.sort(beanNames);
	    for (String beanName : beanNames) {
	      System.out.println(beanName);
	    }
	}

}
