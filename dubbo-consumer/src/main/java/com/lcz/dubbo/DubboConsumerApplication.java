package com.lcz.dubbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
public class DubboConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DubboConsumerApplication.class, args);
	}
}
