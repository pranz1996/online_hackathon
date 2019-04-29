package com.openHack;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//@SuppressWarnings("deprecation")
@SpringBootApplication
public class OnlineHackathonProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineHackathonProjectApplication.class, args);
	}
	
//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurerAdapter( ) {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/hackathons/**")
//	            .allowedOrigins("http://localhost:3000")
//	            .allowedMethods("POST", "GET", "PUT", "DELETE")
//	            .allowedHeaders("Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method", "Access-Control-Request-Headers")
//	            .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials")
//	            .allowCredentials(false);
//			}
//		};
//	}
	
//	@Bean
//	@Lazy(value = true)
//	public JoinRequestDto joinRequestDto() {
//		return new JoinRequestDto();
//
//	}

}
