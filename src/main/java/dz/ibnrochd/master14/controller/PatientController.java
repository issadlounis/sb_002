package dz.ibnrochd.master14.controller;

import dz.ibnrochd.master14.Sb002Application;
import dz.ibnrochd.master14.business.impl.PatientService;
import dz.ibnrochd.master14.model.Patient;
import dz.ibnrochd.master14.model.RendezVous;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    PatientService patientService;

    //Patients
    // TODO : récupérer la liste de tous les patients puis afficher leurs noms
    @GetMapping
    public ResponseEntity<Map<String, Object>> listePatients() {
        List<Patient> patients = patientService.listePatients();
        List<String> patientsNoms = patients.stream().map(Patient::getNom).toList();

        Map<String, Object> response = new HashMap<>();
        response.put("patients", patients);
        response.put("patientsNoms", patientsNoms);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // recuperer un patient ayant un id particulier
    @GetMapping("/{id}")
    public Patient recupererPatient(@PathVariable("id") int id) {
        return patientService.recupererPatient(id);
    }

    // TODO : créer un nouveau patient (valeurs au choix)  PUIS enregistrer-le
    @PostMapping("/")
    public void creerPatient(@RequestBody Patient patient) {
        Patient newPatient = new Patient();
        newPatient.setNom(patient.getNom());
        newPatient.setPrenom(patient.getPrenom());
        newPatient.setSexe(patient.getSexe());
        newPatient.setDateNaissance(patient.getDateNaissance());
        newPatient.setNumeroTelephone(patient.getNumeroTelephone());
        newPatient.setAdresse(patient.getAdresse());

        patientService.creerPatient(newPatient);
    }

    // modifier un patient
    @PutMapping("/{id}")
    public void modifierPatient(@PathVariable("id") int id, @RequestBody Patient patient) {
        patientService.modifierPatient(id, patient);
    }

    // supprimer un patient
    @DeleteMapping("/{id}")
    public void supprimerPatient(@PathVariable("id") int id) {
        patientService.supprimerPatient(id);
    }

    // TODO : rechercher les patients par leurs noms puis afficher leurs prénoms
    @GetMapping("/rechercher")
    public ResponseEntity<Map<String, Object>> rechercherPatients(@RequestParam String nom) {
        List<Patient> patients = patientService.rechercherPatients(nom);

        List<String> patientsPrenoms = null;

        if(!patients.isEmpty()) {
            patientsPrenoms = patients.stream().map(Patient::getPrenom).toList();
        }

        Map<String, Object> response = new HashMap<>();
        response.put("patients", patients);
        response.put("patientsPrenoms", patientsPrenoms);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Rendez-vous
    // liste des rendez-vous
    @GetMapping("/rendez-vous")
    public List<RendezVous> listeRendezVous() {
        return patientService.listeRendezVous();
    }

    // liste des rendez-vous d'un patient
    @GetMapping("/{idPatient}/rendez-vous")
    public List<RendezVous> listeRendezVousPatient(@PathVariable("idPatient") int idPatient) {
        return patientService.listeRendezVousPatient(idPatient);
    }

    // prendre un rendez-vous
    @PostMapping("/rendez-vous")
    public void prendreRendezVous(@RequestBody RendezVous rendezVous) {
        RendezVous newRendezVous = new RendezVous();
        newRendezVous.setDateRdv(rendezVous.getDateRdv());
        newRendezVous.setIdPatient(rendezVous.getIdPatient());

        patientService.prendreRendezVous(newRendezVous);
    }

    // modifier un rendez-vous
    @PutMapping("/rendez-vous/{id}")
    public void modifierRendezVous(@PathVariable("id") int id, @RequestBody RendezVous rendezVous) {
        patientService.modifierRendezVous(id, rendezVous);
    }

    // supprimer un rendez-vous
    @DeleteMapping("/rendez-vous/{id}")
    public void supprimerRendezVous(@PathVariable("id") int id) {
        patientService.supprimerRendezVous(id);
    }

}
