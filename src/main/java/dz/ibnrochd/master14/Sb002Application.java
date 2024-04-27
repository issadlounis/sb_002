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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
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


		// TODO : rechercher les patients ayant le nom "Yahi" puis leurs prénoms
		
		
		// TODO : créer un nouveau patient (valeurs au choix)  PUIS enregistrer-le

				
		// TODO : rechercher la consultation ayant id=3 
		

		// TODO : parcourir les lignes de la consultation trouvée et afficher les noms des médicaments
		
	}

	// récupérer la liste de tous les patients puis afficher leurs noms
	@GetMapping("/patients")
	public ResponseEntity<Map<String, Object>> listePatients() {
		List<Patient> patients = patientMapper.listePatients();
		List<String> patientsNoms = patients.stream().map(Patient::getNom).toList();

		Map<String, Object> response = new HashMap<>();
		response.put("patients", patients);
		response.put("patientsNoms", patientsNoms);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	// rechercher les patients ayant le nom "Yahi" puis leurs prénoms
	@GetMapping("/patients/rechercher")
	public ResponseEntity<Map<String, Object>> rechercherPatients() {
		List<Patient> patients = patientMapper.rechercherPatients();
		List<String> patientsPrenoms = patients.stream().map(Patient::getPrenom).toList();

		Map<String, Object> response = new HashMap<>();
		response.put("patients", patients);
		response.put("patientsPrenoms", patientsPrenoms);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	// créer un nouveau patient (valeurs au choix)  PUIS enregistrer-le
	@PostMapping("/patients")
	public void creerPatient(@RequestBody Patient patient) {
		Patient newPatient = new Patient();
		newPatient.setNom(patient.getNom());
		newPatient.setPrenom(patient.getPrenom());
		newPatient.setSexe(patient.getSexe());
		newPatient.setDateNaissance(patient.getDateNaissance());
		newPatient.setNumeroTelephone(patient.getNumeroTelephone());
		newPatient.setAdresse(patient.getAdresse());

		patientMapper.savePatient(newPatient);
	}

	// rechercher la consultation ayant id=3
	@GetMapping("/consultation/rechercher")
	public Consultation rechercherConsultation() {
		return consultationMapper.rechercherConsultation();
	}
	/*
	public ResponseEntity<?> rechercherConsultation() {
		Consultation consultation =  consultationMapper.rechercherConsultation();

		// parcourir les lignes de la consultation trouvée et afficher les noms des médicaments
		List<String> traitementsNoms = consultationMapper.rechercherTraitement();

		Map<String, Object> response = new HashMap<>();
		response.put("consultation", consultation);
		response.put("traitementsNoms", traitementsNoms);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}*/

	// parcourir les lignes de la consultation trouvée et afficher les noms des médicaments
	@GetMapping("/traitement/rechercher")
	public List<String> rechercherTraitement() {
		return traitementMapper.rechercherTraitement();
	}

}
