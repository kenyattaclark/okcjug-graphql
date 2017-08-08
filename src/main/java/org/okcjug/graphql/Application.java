package org.okcjug.graphql;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.text.SimpleDateFormat;

@Configuration
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public Jackson2ObjectMapperBuilder objectMapperBuilder() {
		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();

		builder.dateFormat(new SimpleDateFormat("yyyy-MM-dd"));
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule())
				.registerModule(new ParameterNamesModule())
				.registerModule(new Jdk8Module());

		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		builder.configure(mapper);
		return builder;
	}
}
