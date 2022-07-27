package com.jbk.ProductManagement_MVC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ProductManagementMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductManagementMvcApplication.class, args);
		System.out.println("Welcome");
	}

}
