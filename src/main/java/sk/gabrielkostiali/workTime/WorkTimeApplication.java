package sk.gabrielkostiali.workTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sk.gabrielkostiali.workTime.model.Employee;

@SpringBootApplication
public class WorkTimeApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkTimeApplication.class, args);
	}

}
