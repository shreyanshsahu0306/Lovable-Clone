package com.myprojects.clone.Lovable_clone;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class LovableCloneApplication {

	static {
		System.out.println("JVM TimeZone (static) = " + java.util.TimeZone.getDefault());
	}

	public static void main(String[] args) {
		SpringApplication.run(LovableCloneApplication.class, args);
	}


}
