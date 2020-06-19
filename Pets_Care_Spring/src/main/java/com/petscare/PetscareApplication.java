package com.petscare;

import java.time.LocalDate;
import java.util.ArrayList;

import com.petscare.model.Collaborator;
import com.petscare.model.Service;
import com.petscare.model.StoryService;
import com.petscare.model.User;
import com.petscare.services.CollaboratorService;
import com.petscare.services.UserService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;

@SpringBootApplication
public class PetscareApplication {

	@Bean
	public Java8TimeDialect java8TimeDialect() {
		return new Java8TimeDialect();
	}
	public static void main(String[] args) {
		ConfigurableApplicationContext c = SpringApplication.run(PetscareApplication.class, args);

		UserService userService = c.getBean(UserService.class);
		CollaboratorService collService = c.getBean(CollaboratorService.class);

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		User  usr = new User();
		usr.setId((long)1061814203);
		usr.setName("jhusseth");
		usr.setEmail("jhussetharias@gmail.com");
		usr.setPassword(passwordEncoder.encode("1971"));
		usr.setAddress("cr 44 #14a-40 barrio la selva");
		usr.setDateBorn(LocalDate.of(1998, 11, 18));
		usr.setPhone("3124283627");
		//usr.setStoryServices(new StoryService());


		Collaborator  coll= new Collaborator();
		coll.setId((long)1061814203);
		coll.setName("jhusseth2");
		coll.setEmail("jhusseth1@hotmail.com");
		coll.setPassword(passwordEncoder.encode("1971"));
		coll.setAddress("cr 44 #14a-40 barrio la selva");
		coll.setDateBorn(LocalDate.of(1998, 11, 18));
		coll.setPhone("3124283627");
		coll.setDescription("amo los animales");
		//coll.setServices(new ArrayList<Service>());

		userService.save(usr);
		collService.save(coll);
		
	}

}
