package com.nataliogomes.eventmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@SpringBootApplication
@RestController
public class EventmanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventmanagerApplication.class, args);
	}

	@Bean
	public ErrorViewResolver customErrorViewResolver() {
		ModelAndView error404 = new ModelAndView("error");
		error404.setStatus(HttpStatus.NOT_FOUND);
		return (request, status, model) -> status == HttpStatus.NOT_FOUND ? error404 : null;
	}

	// Redirect to the custom "Page Not Found" view for unhandled URLs
	@Bean
	public WebMvcConfigurer webMvcConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addViewControllers(ViewControllerRegistry registry) {
				registry.addViewController("/error").setViewName("error");
			}
		};
	}

}
