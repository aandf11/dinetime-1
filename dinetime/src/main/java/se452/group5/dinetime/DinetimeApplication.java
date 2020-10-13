package se452.group5.dinetime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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
	


	Restaurant newRestaurant;

	@Bean
	public CommandLineRunner addRestaurant(RestaurantRepository repository){
	  return (args) -> {
		newRestaurant = new Restaurant();
		newRestaurant.setLocation_id("25871");
		

		RestaurantDetail newRestaurantDetail=new RestaurantDetail();
		newRestaurantDetail.setBusiness_nm("PAPAS LITTLE BAKERY");
		newRestaurantDetail.setRestaurants_type("BAKERY");
		newRestaurant.setRestaurantDetail(newRestaurantDetail);

		RestaurantLocation newRestaurantLocation =new RestaurantLocation();
		newRestaurantLocation.setAddress("153 Main St. Chicago, IL");
		newRestaurantLocation.setTableNum(4);
		newRestaurant.setRestaurantLocation(newRestaurantLocation);


		TableAvailability newTable=new TableAvailability();
		newTable.setRestaurant(newRestaurant);
		newTable.setTable_id("02433");
		newTable.setSeats(4);
		newTable.setAvailable(true);
		newTable.setTime("13:00");

		DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
		java.sql.Date sqlDate = new java.sql.Date(df.parse("02-04-2020").getTime());
		newTable.setDate(sqlDate);
	
		newRestaurant.getTableList().add(newTable);
		repository.save(newRestaurant);
	  };
	}



	CustomerAccount newCustomerAccount;
	@Bean
	public CommandLineRunner addCustomerAccount(CustomerAccountRepository repository){
	  return (args) -> {
		//test add customer
		newCustomerAccount = new CustomerAccount();
		newCustomerAccount.setEmail("james@bond.uk");
		newCustomerAccount.setName("James Bond");
		newCustomerAccount.setUserId("12356");

		//use customer to add new rate
		Rate newRate =new Rate();
		newRate.setCustomerAccount(newCustomerAccount);
		newCustomerAccount.getRateList().add(newRate);
		newRate.setRestaurant_name("PAPAS LITTLE BAKERY");
		RateDetail rateDetail= new RateDetail();
		rateDetail.setRate(newRate);
		rateDetail.setRate_stars(4);
		

		newRate.setRateDetail(rateDetail);
		repository.save(newCustomerAccount);
		
	  };
	}

	
	








	
}
