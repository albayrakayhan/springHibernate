package com.maybacth.springHibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude= HibernateJpaAutoConfiguration.class)
public class SpringHibernateApplication { 

	public static void main(String[] args) {
		SpringApplication.run(SpringHibernateApplication.class, args);
	}

}
