package com.javarock.repository;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {UserRepoTest.Config.class})
public class UserRepoTest {
	
	@Resource
	UserRepository repo;
	
	@Test
	public void test() {
		Assert.assertTrue(true);
	}

	
	@Configuration
	@EntityScan(basePackages={"com.javarock.model"})
	@EnableJpaRepositories(basePackages={"com.javarock.repository"})
	@EnableAutoConfiguration
	public static class Config {
		
		@Bean
		public DataSource dataSource() {
			
			// no need shutdown, EmbeddedDatabaseFactoryBean will take care of this
			EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
			EmbeddedDatabase db = builder
				.setType(EmbeddedDatabaseType.HSQL) //.H2 or .DERBY
				.addScript("db/BLOG_DDL_001.sql")
				.build();
			return db;
		}

	}
	
}
