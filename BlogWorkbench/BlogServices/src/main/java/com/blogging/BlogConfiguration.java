package com.blogging;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.blogging.validator.ValidatingMongoEventListener;

@Configuration
@EnableMongoRepositories(basePackages = { "com.blogging.repository" })
@EntityScan(basePackages = { "com.blogging.model" })
@EnableAutoConfiguration
public class BlogConfiguration {

	@Bean
	public ValidatingMongoEventListener validatingMongoEventListener() {
		ValidatingMongoEventListener listner = new ValidatingMongoEventListener();
		listner.setValidator(validator());
		return listner;
	}

	@Bean
	public LocalValidatorFactoryBean validator() {
		return new LocalValidatorFactoryBean();
	}

}
