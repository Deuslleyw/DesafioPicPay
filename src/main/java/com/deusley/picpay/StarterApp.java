package com.deusley.picpay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class StarterApp {

	public static void main(String[] args) {
		SpringApplication.run(StarterApp.class, args);


	}

}
