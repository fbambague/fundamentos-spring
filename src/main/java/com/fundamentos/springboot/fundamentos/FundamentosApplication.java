package com.fundamentos.springboot.fundamentos;

import com.fundamentos.springboot.fundamentos.bean.MyBean;
import com.fundamentos.springboot.fundamentos.bean.MyBeanWithDependency;
import com.fundamentos.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentos.springboot.fundamentos.component.ComponentDependency;
import com.fundamentos.springboot.fundamentos.entity.User;
import com.fundamentos.springboot.fundamentos.pojo.UserPojo;
import com.fundamentos.springboot.fundamentos.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication  implements CommandLineRunner {

	private final Log LOGGER = LogFactory.getLog(FundamentosApplication.class);

	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;

	private UserRepository userRepository;

	public FundamentosApplication (ComponentDependency componentDependency,
								   MyBean myBean,
								   MyBeanWithDependency myBeanWithDependency,
								   MyBeanWithProperties myBeanWithProperties,
								   UserPojo userPojo,
								   UserRepository userRepository){

		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//ejemplosIniciales();
		saveUser();
		getInformationJpqlFromUser();
	}

	public void saveUser(){
		User user1 = new User("leo"
							,"lmessi@mail.com"
							, LocalDate.of(1985,02,03));
		User user2 = new User("cris"
				,"cronaldo@mail.com"
				, LocalDate.of(1983,02,03));
		User user3 = new User("alison"
				,"abecker@mail.com"
				, LocalDate.of(1989,02,03));
		User user4 = new User("moh"
				,"msalah@mail.com"
				, LocalDate.of(1990,02,03));
		User user5 = new User("kylli"
				,"kmbappe@mail.com"
				, LocalDate.of(1999,02,03));
		User user6 = new User("cris2"
				,"cronaldo2@mail.com"
				, LocalDate.of(1983,02,03));
		List<User> users = Arrays.asList(user1,user2,user3,user4,user5,user6);
//		userRepository.saveAll(users);
		users.stream().forEach(userRepository::save);
	}

	private	void getInformationJpqlFromUser(){
/*
		LOGGER.info("user found with method findByEmail: "+ userRepository.findByEmail("kmbappe@mail.com")
				.orElseThrow(()->
					new RuntimeException("User not found")
		));

		userRepository.findAndSort("cris", Sort.by("id").ascending())
				.stream()
				.forEach(user -> LOGGER.info("User found with method findAndSort: "+user));

		userRepository.findByName("cris")
				.stream()
				.forEach(user -> LOGGER.info("User found with method findByName: "+user));

		LOGGER.info("User found with method findByNameAndEmail: "+
		userRepository.findByNameAndEmail("cris","cronaldo@mail.com")
				.orElseThrow(()->new RuntimeException("User not found")));

		userRepository.findByNameLike("%c%")
				.stream()
				.forEach(user -> LOGGER.info("User foind with method findByNameLike: "+user));

		userRepository.findByNameOrEmail(null,"msalah@mail.com")
				.stream()
				.forEach(user -> LOGGER.info("User found with method findByNameOrEmail: "+user));

		userRepository.findByDobBetween(LocalDate.of(1999,01,01),
										LocalDate.of(1999,12,31))
				.stream()
				.forEach(user -> LOGGER.info("User found with method findByDobBetween: "));

		userRepository.findByNameLikeOrderByIdDesc("%cr%")
				.stream()
				.forEach(user -> LOGGER.info("User found with method findByNameLikeOrderByIdDesc: "+user));

		LOGGER.info("User found with method getAllByBirthDateAndEmail: "+
		userRepository.getAllByBirthDateAndEmail(LocalDate.of(1990,02,03)
												,"msalah@mail.com")
				.orElseThrow(()->new RuntimeException("User not found")));
 */

		userRepository.findByNameContainingOrderByIdDesc("cr")
				.stream()
				.forEach(user -> LOGGER.info("User found with method findByNameContainingOrderByIdDesc: "+user));


	}

	public void ejemplosIniciales(){
		componentDependency.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		System.out.println(myBeanWithProperties.function());
		System.out.println(userPojo.getEmail()+" "+userPojo.getPassword());

		try{
			int value= 1/0;
			LOGGER.debug("Mi valor: "+value);
		}catch(Exception e){
			LOGGER.error("Error división por 0: "+e.getMessage());

		}

		LOGGER.error("Error de aplicación");
	}
}
