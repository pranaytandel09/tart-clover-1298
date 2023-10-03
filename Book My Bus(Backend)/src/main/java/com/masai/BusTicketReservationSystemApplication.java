package com.masai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class BusTicketReservationSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusTicketReservationSystemApplication.class, args);
	}
}