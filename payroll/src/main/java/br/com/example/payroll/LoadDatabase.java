package br.com.example.payroll;

import java.util.logging.Logger;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class LoadDatabase {

	@Bean
	CommandLineRunner initDatabase(EmployeeRepository repository) {
		return args -> {
			/* TODO: Transient solution. Need to repair lombok dependency */
			Logger.getAnonymousLogger().info("Preloading " + repository.save(new Employee("Bilbo Baggins", "burglar")));
			Logger.getAnonymousLogger().info("Preloading " + repository.save(new Employee("Frodo Baggins", "thief")));
//			log.info("Preloading " + repository.save(new Employee("Bilbo Baggins", "burglar")));
//			log.info("Preloading " + repository.save(new Employee("Frodo Baggins", "thief")));
		};
	}
}
