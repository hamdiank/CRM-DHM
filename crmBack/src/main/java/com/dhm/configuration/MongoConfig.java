package com.dhm.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;

@Configuration
public class MongoConfig {
	public @Bean
	MongoDbFactory mongoDbFactory()throws Exception{
		return new SimpleMongoDbFactory(new MongoClient(), "crm") ;
	}
	 public @Bean
	    MongoTemplate mongoTemplate() throws Exception {
	        MongoTemplate mongtemplate  = new MongoTemplate(mongoDbFactory()) ;
	         return mongtemplate ;
	    }


}
