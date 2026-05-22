package sn.ia.gestion_assurance;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sn.ia.gestion_assurance.entity.Type;
import sn.ia.gestion_assurance.repository.TypeRepository;

@SpringBootApplication
public class GestionAssuranceApplication {

	public static void main(String[] args) {

		SpringApplication.run(GestionAssuranceApplication.class, args);



	}


	/*@Bean
	public CommandLineRunner test(TypeRepository typeRepository) {
		return args -> {

				typeRepository.deleteById(1L);


		};
	}*/
}
