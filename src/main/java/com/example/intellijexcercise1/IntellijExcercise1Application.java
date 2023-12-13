package com.example.intellijexcercise1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class IntellijExcercise1Application {

	public static void main(String[] args) {

		SpringApplication.run(IntellijExcercise1Application.class, args);
	}

}
