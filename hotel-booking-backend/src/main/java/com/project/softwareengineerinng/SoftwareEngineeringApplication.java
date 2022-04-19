package com.project.softwareengineerinng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SoftwareEngineeringApplication {
	// @Autowired
	// private UserRepository repository;
	//
	// @PostConstruct
	// public void initUsers() {
	// List<User> users = Stream.of(
	// new User(101L, "godwin", "password", "godwin@gmail.com"),
	// new User(102L, "user1", "pwd1", "user1@gmail.com"),
	// new User(103L, "user2", "pwd2", "user2@gmail.com"),
	// new User(104L, "user3", "pwd3", "user3@gmail.com")
	// ).collect(Collectors.toList());
	// repository.saveAll(users);
	// }

	public static void main(String[] args) {
		SpringApplication.run(SoftwareEngineeringApplication.class, args);
	}

}
