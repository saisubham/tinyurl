package com.example.tinyurl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TinyurlApplication {

	static void main(String[] args) {
		SpringApplication.run(TinyurlApplication.class, args);
	}

}
