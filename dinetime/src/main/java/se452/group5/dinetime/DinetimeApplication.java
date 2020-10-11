package se452.group5.dinetime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class DinetimeApplication {

	@Value( "${app.greeting}" )
    private String greeting;
  
    @Bean
    public CommandLineRunner showMessage() {
      return (args) -> {
        System.out.println("begin encoded");
        System.out.println(greeting);
              System.out.println("end encoded");
      };
	} 
	

	public static void main(String[] args) {
		SpringApplication.run(DinetimeApplication.class, args);
	}
	// @Bean
	// public void samplerCustomersetterandgettertest(){
	// 	Customer c = new Customer();
	// 	c.setName("MARKY");
		
	// }
}
