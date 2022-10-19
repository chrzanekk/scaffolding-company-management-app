package pl.com.chrzanowski.scma;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.com.chrzanowski.scma.service.UserService;

@SpringBootApplication
public class ScaffoldingCompanyManagementAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScaffoldingCompanyManagementAppApplication.class, args);
	}



}
