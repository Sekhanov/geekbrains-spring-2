package com.skhanov.geekbrainsspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class GeekbrainsSpring2Application implements WebMvcConfigurer {
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("redirect:/index");
		registry.addViewController("index").setViewName("index");
		registry.addViewController("blog").setViewName("blog");
		registry.addViewController("cart").setViewName("cart");
		// registry.addViewController("category").setViewName("category");
		registry.addViewController("checkout").setViewName("checkout");
		registry.addViewController("confirmation").setViewName("confirmation");
		registry.addViewController("contact").setViewName("contact");
		registry.addViewController("register").setViewName("register");
		registry.addViewController("single-blog").setViewName("single-blog");
		// registry.addViewController("single-product").setViewName("single-product")
		registry.addViewController("tracking-order").setViewName("tracking-order");
		registry.addViewController("admin").setViewName("redirect:admin/main");
		registry.addViewController("admin/main").setViewName("admin/main");		
	}

	public static void main(String[] args) {
		SpringApplication.run(GeekbrainsSpring2Application.class, args);
	}

}
