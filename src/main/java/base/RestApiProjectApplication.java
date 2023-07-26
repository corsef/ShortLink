package base;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication()
public class RestApiProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiProjectApplication.class, args);
		//PersonResponse personResponse = new PersonResponse(1,"kerem","kahraman","software engineer", "Etiya","asdfg");
		//PersonResponse.GetNecessaryInfo("kerem","kahraman");

	}

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
}
