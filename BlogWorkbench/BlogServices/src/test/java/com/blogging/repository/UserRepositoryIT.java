package com.blogging.repository;

import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.blogging.Application;
import com.blogging.model.User;
import com.mongodb.Mongo;
import com.mongodb.MongoClientOptions;

import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodProcess;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.IMongodConfig;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class, UserRepositoryIT.Config.class})
public class UserRepositoryIT {
	
	@Resource
	private UserRepository userRepo;

	@Test
	public void test() {
		
		User user = new User();
		user.setCreatedDate(new Date());
		user.setFirstName("TestName");
		user.setEmail("abc@abc.com");
		user.setLastName("TestLastName");
		user.setPassword("test");
		
		System.out.println("userRepo "+ userRepo);
		
		User save = userRepo.save(user);
		System.out.println("save" + save.getUserId());
		
	}
	
	
	@Configuration
//	@EnableMongoRepositories(basePackages={"com.blogging.repository"})
//	@EntityScan(basePackages={"com.blogging.model"})
//	@EnableAutoConfiguration(exclude={EmbeddedMongoAutoConfiguration.class})
	public static class Config {
		
		private static final MongodStarter starter = MongodStarter.getDefaultInstance();

	    @Autowired
	    private MongoProperties properties;

	    @Autowired(required = false)
	    private MongoClientOptions options;

	    @Bean(destroyMethod = "close")
	    public Mongo mongo() throws IOException {
	        Net net = mongod().getConfig().net();
	        System.out.println("host is "+ net.getServerAddress().getHostName());
	        properties.setHost(net.getServerAddress().getHostName());
	        properties.setPort(net.getPort());
	        return properties.createMongoClient(this.options);
	    }

	    @Bean(destroyMethod = "stop")
	    public MongodProcess mongod() throws IOException {
	        return mongodExe().start();
	    }

	    @Bean(destroyMethod = "stop")
	    public MongodExecutable mongodExe() throws IOException {
	        return starter.prepare(mongodConfig());
	    }

	    @Bean
	    public IMongodConfig mongodConfig() throws IOException {
	        return new MongodConfigBuilder().version(Version.Main.PRODUCTION).build();
	    }

		
	}

}
