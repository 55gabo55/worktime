package sk.gabrielkostiali.workTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import sk.gabrielkostiali.workTime.model.Employee;

@SpringBootApplication
public class WorkTimeApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkTimeApplication.class, args);
	}



}
