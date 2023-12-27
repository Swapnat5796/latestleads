package com.company.lead;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.company.lead" })
public class LeadApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeadApplication.class, args);
	}

}
