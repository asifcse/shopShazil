package com.khanAsif.shopShazil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("com.khanAsif.shopShazil")
public class ShopShazilApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopShazilApplication.class, args);
	}

}
