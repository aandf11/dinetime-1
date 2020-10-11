package se452.group5.dinetime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class DinetimeApplication {


	public static void main(String[] args) {
		SpringApplication.run(DinetimeApplication.class, args);
	}
	

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
	

	// @Bean
	// public void samplerCustomersetterandgettertest(){
	// 	Customer c = new Customer();
	// 	c.setName("MARKY");
		
	// }

	@Bean
	public CommandLineRunner addCustomerAccount(CustomerAccountRepository repository){
	  return (args) -> {
		CustomerAccount newCustomerAccount = new CustomerAccount();
		newCustomerAccount.setEmail("james@bond.uk");
		newCustomerAccount.setName("James Bond");
		repository.save(newCustomerAccount);
	  };
  
	}
}
