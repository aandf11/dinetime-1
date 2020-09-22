package se452.group5.dinetime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DinetimeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DinetimeApplication.class, args);
	}
	@Bean
	public void samplerCustomersetterandgettertest(){
		Customer c = new Customer();
		c.setName("MARKY");
		
	}
}
