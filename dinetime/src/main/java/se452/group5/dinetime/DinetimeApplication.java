package se452.group5.dinetime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;


@SpringBootApplication
public class DinetimeApplication {
	@Value( "${spring.profiles.active}" )
    private String env;

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
		System.out.println(env);
      };
	} 

	@Configuration
    public class WebConfig implements WebMvcConfigurer {      
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/**")
            .addResourceLocations("classpath:/static/","classpath:/images/")
            .setCachePeriod(0);
        }
    }


	
	








	
}
