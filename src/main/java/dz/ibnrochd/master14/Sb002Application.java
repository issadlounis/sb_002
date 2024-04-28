package dz.ibnrochd.master14;

import dz.ibnrochd.master14.dao.ConsultationMapper;
import dz.ibnrochd.master14.dao.PatientMapper;
import dz.ibnrochd.master14.dao.TraitementMapper;
import dz.ibnrochd.master14.model.Consultation;
import dz.ibnrochd.master14.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Sb002Application implements CommandLineRunner {
	@Autowired
	PatientMapper patientMapper;

	@Autowired
	ConsultationMapper consultationMapper;

	@Autowired
	TraitementMapper traitementMapper;

	// TODO : déclarer les autres repository de la même façon que PatientRepository
	

	public static void main(String[] args) {
		SpringApplication.run(Sb002Application.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		// TODO : récupérer la liste de tous les patients puis afficher leurs noms
		List<Patient> patients = patientMapper.listePatients();

		patients.forEach(System.out::println);

		patients.forEach(patient -> System.out.println(patient.getNom()));

		// TODO : rechercher les patients ayant le nom "Yahi" puis leurs prénoms
		List<Patient> patientsRechercher = patientMapper.rechercherPatients();

		patientsRechercher.forEach(System.out::println);

		patientsRechercher.stream().map(Patient::getPrenom).forEach(System.out::println);
		
		// TODO : créer un nouveau patient (valeurs au choix)  PUIS enregistrer-le
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date birthDate = dateFormat.parse("1999-06-14");


		Patient newPatient = new Patient();
		newPatient.setNom("Issad");
		newPatient.setPrenom("Lounis");
		newPatient.setSexe("m");
		newPatient.setDateNaissance(birthDate);
		newPatient.setNumeroTelephone("0666666666");
		newPatient.setAdresse("Tizi Ouzou");

		patientMapper.savePatient(newPatient);
				
		// TODO : rechercher la consultation ayant id=3
		Consultation consultation = consultationMapper.rechercherConsultation();

		System.out.println(consultation);

		// TODO : parcourir les lignes de la consultation trouvée et afficher les noms des médicaments
		List<String> traitementsNoms = traitementMapper.rechercherTraitement(consultation.getId());

		traitementsNoms.forEach(System.out::println);
	}

}
