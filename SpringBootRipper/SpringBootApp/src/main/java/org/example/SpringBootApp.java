package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootApp {

	/*
	This bean will suppress our RavenListener from EnableAutoConfig module.
	And it doesn't matter for Spring that we return different class -> String in this configuration.
	Spring will resolve bean by the method name "ravenListener" and create String instead of RavenListener.class
	 */
//	@Bean
//	public String ravenListener() {
//		System.out.println("Another raven listener");
//		return "bugaga";
//	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApp.class, args);
		//Checked production 2 times:
		//String bean requested
		//A raven was sent to: Westeros
		//A raven was sent to: Bravos
	}

}
