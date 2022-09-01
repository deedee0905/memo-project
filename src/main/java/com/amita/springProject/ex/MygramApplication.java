package com.amita.springProject.ex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication

public class MygramApplication {

	public static void main(String[] args) {
		SpringApplication.run(MygramApplication.class, args);
	}

}
