package com.thp.spring.simplecontext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.thp.spring.helper.ModelMapperConverter;


//@ComponentScan({"com.thp.spring.controller"})
//@EnableJpaRepositories("com.thp.spring.repository")
//@EnableConfigurationProperties
//@EntityScan(basePackages = {"com.thp.spring.entity"})
/*
@SpringBootApplication
@EnableConfigurationProperties
*/
//@ComponentScan({"com.thp.spring"})


/*
   @Configuration
    @SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
    @EnableJpaRepositories("com.example.demo.Repository")
    @EntityScan("com.example.demo.data")
    @ComponentScan(basePackages="com.example.demo.service,com.example.demo.Controller")
    @EnableCaching
 */
//@ComponentScan("com.thp.spring.repository")



@SpringBootApplication
//@EnableConfigurationProperties
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.thp.spring.entity"})
@ComponentScan(basePackages={"com.thp.spring.controller",
"com.thp.spring.serviceImpl","com.thp.spring.helper"})
@EnableJpaRepositories(basePackages={"com.thp.spring.repository"})
@EnableTransactionManagement
public class VintudSpringBootApplication   extends SpringBootServletInitializer {


	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(VintudSpringBootApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(VintudSpringBootApplication.class, args);
    }
    

    

}



