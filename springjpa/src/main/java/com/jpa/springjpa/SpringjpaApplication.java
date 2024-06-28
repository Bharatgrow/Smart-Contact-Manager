package com.jpa.springjpa;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringjpaApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(SpringjpaApplication.class, args);

		UserRepository userRepository= context.getBean(UserRepository.class);

		User user=new User();
	// 	user.setName("Bharat");
	// 	user.setCity("jabalpur");
	// 	user.setStatus("ok");
		

	// User user1=	userRepository.save(user);
	// System.out.println(user1);

	//Update

	// Optional<User> optional=userRepository.findById(2);
	// User user2=optional.get();

	// user2.setName("mayank");
	// User result=userRepository.save(user2);
	// System.out.println(result);


	// userRepository.deleteById(2);

	// List<User>users=userRepository.findByName("bharat");
	// users.forEach(e->System.out.println(e));

	// List<User>users=userRepository.findByIdLessThan(100);
	// users.forEach(e->System.out.println(e));

	// List<User> users=userRepository.getAllUser();
	// users.forEach(e->System.out.println(e));

	List<User> users=userRepository.getById(52);
	users.forEach(e->System.out.println(e));

	}

}
