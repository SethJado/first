package com.Employee.EmployeeBack;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
@SpringBootApplication
public class EmployeeBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeBackApplication.class, args);
	}
	
/*	@Bean
	public HibernateJpaSessionFactoryBean sessionFactory(EntityManagerFactory emf) {
	    HibernateJpaSessionFactoryBean factory = new HibernateJpaSessionFactoryBean();
	    factory.setEntityManagerFactory(emf);
	    return factory;
	}*/

}
