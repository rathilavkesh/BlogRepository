package com.blogging;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = { "com.blogging.repository" })
@EntityScan(basePackages = { "com.blogging.model" })
@EnableAutoConfiguration
public class BlogConfiguration {

}
