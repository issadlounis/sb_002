package dz.ibnrochd.master14;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Sb002Application implements CommandLineRunner {

	// TODO : rechercher la consultation ayant id=3

	// TODO : parcourir les lignes de la consultation trouvée et afficher les noms des médicaments

	public static void main(String[] args) {
		SpringApplication.run(Sb002Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {}

}
