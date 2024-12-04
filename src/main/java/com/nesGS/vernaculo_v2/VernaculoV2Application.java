package com.nesGS.vernaculo_v2;

import com.nesGS.vernaculo_v2.persistence.model.Club;
import com.nesGS.vernaculo_v2.persistence.repository.ClubRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VernaculoV2Application {

	public static void main(String[] args) {
		SpringApplication.run(VernaculoV2Application.class, args);
	}

//	@Bean
//	CommandLineRunner initDatabase(ClubRepository clubRepository) {
//		return args -> {
//			// Insertar datos de ejemplo
//			clubRepository.save(new Club(null, "Club Tegueste", "Tegueste", "www.teguestelucha.com", null, null));
//			clubRepository.save(new Club(null, "Club Tenerife", "Santa Cruz", "www.clubtenerife.com", null, null));
//			clubRepository.save(new Club(null, "Club Gran Canaria", "Las Palmas", "www.clubgrancanaria.com", null, null));
//
//			System.out.println("Datos de prueba insertados correctamente.");
//		};
//	}
}
