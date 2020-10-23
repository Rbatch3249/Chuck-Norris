package com.example.chuckNorris;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ChuckNorrisApplication {

public static final Logger log = LoggerFactory.getLogger(ChuckNorrisApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(ChuckNorrisApplication.class, args);
	}
@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder){
		return builder.build();
}
@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception{
		return args -> {
			Icon_Url icon = restTemplate.getForObject(
					"https://api.chucknorris.io/jokes/random", Icon_Url.class);
			log.info(icon.toString());
		};
		}
}


