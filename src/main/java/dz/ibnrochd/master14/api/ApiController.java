package dz.ibnrochd.master14.api;

import dz.ibnrochd.master14.business.impl.ConsultationService;
import dz.ibnrochd.master14.business.impl.PatientService;
import dz.ibnrochd.master14.business.impl.TraitementService;
import dz.ibnrochd.master14.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ApiController {
    private final PatientService patientService;
    private final TraitementService traitementService;
    private final ConsultationService consultationService;

    @Autowired
    public ApiController(PatientService patientService, TraitementService traitementService, ConsultationService consultationService) {
        this.patientService = patientService;
        this.traitementService = traitementService;
        this.consultationService = consultationService;
    }

    //Patients
    // TODO : récupérer la liste de tous les patients puis afficher leurs noms
    @GetMapping("/api/patients")
    public ResponseEntity<Map<String, Object>> listePatients() {
        List<Patient> patients = patientService.listePatients();
        List<String> patientsNoms = patients.stream().map(Patient::getNom).toList();

        Map<String, Object> response = new HashMap<>();
        response.put("patients", patients);
        response.put("patientsNoms", patientsNoms);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // recuperer un patient ayant un id particulier
    @GetMapping("/api/patients/{id}")
    public Patient recupererPatient(@PathVariable("id") int id) {
        return patientService.recupererPatient(id);
    }

    // TODO : créer un nouveau patient (valeurs au choix)  PUIS enregistrer-le
    @PostMapping("/api/patients")
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
    @PutMapping("/api/patients/{id}")
    public void modifierPatient(@PathVariable("id") int id, @RequestBody Patient patient) {
        patientService.modifierPatient(id, patient);
    }

    // supprimer un patient
    @DeleteMapping("/api/patients/{id}")
    public void supprimerPatient(@PathVariable("id") int id) {
        patientService.supprimerPatient(id);
    }

    // TODO : rechercher les patients par leurs noms puis afficher leurs prénoms
    @GetMapping("/api/patients/rechercher")
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
    @GetMapping("/api/patients/rendez-vous")
    public List<RendezVous> listeRendezVous() {
        return patientService.listeRendezVous();
    }

    // liste des rendez-vous d'un patient
    @GetMapping("/api/patients/{idPatient}/rendez-vous")
    public List<RendezVous> listeRendezVousPatient(@PathVariable("idPatient") int idPatient) {
        return patientService.listeRendezVousPatient(idPatient);
    }

    // prendre un rendez-vous
    @PostMapping("/api/patients/rendez-vous")
    public void prendreRendezVous(@RequestBody RendezVous rendezVous) {
        RendezVous newRendezVous = new RendezVous();
        newRendezVous.setDateRdv(rendezVous.getDateRdv());
        newRendezVous.setIdPatient(rendezVous.getIdPatient());

        patientService.prendreRendezVous(newRendezVous);
    }

    // modifier un rendez-vous
    @PutMapping("/api/patients/rendez-vous/{id}")
    public void modifierRendezVous(@PathVariable("id") int id, @RequestBody RendezVous rendezVous) {
        patientService.modifierRendezVous(id, rendezVous);
    }

    // supprimer un rendez-vous
    @DeleteMapping("/api/patients/rendez-vous/{id}")
    public void supprimerRendezVous(@PathVariable("id") int id) {
        patientService.supprimerRendezVous(id);
    }

    // Traitements
    // récupérer la liste de tous les traitements
    @GetMapping("/api/traitements")
    public List<Traitement> listeTraitements() {
        return traitementService.listeTraitements();
    }

    // recuperer un traitement ayant un id particulier
    @GetMapping("/api/traitements/{id}")
    public Traitement recupererTraitement(@PathVariable("id") int id) {
        return traitementService.recupererTraitement(id);
    }

    // créer un nouveau traitement
    @PostMapping("/api/traitements")
    public void creerTraitement(@RequestBody Traitement traitement) {
        Traitement newTraitement = new Traitement();
        newTraitement.setNom(traitement.getNom());

        traitementService.creerTraitement(newTraitement);
    }

    // modifier un traitement
    @PutMapping("/api/traitements/{id}")
    public void modifierTraitement(@PathVariable("id") int id, @RequestBody Traitement traitement) {
        traitementService.modifierTraitement(id, traitement);
    }

    // supprimer un traitement
    @DeleteMapping("/api/traitements/{id}")
    public void supprimerTraitement(@PathVariable("id") int id) {
        traitementService.supprimerTraitement(id);
    }

    // rechercher les traitements par leurs noms
    @GetMapping("/api/traitements/rechercher")
    public List<Traitement> rechercherTraitements(@RequestParam String nom) {
        return traitementService.rechercherTraitements(nom);
    }

    // Consultations
    // récupérer la liste de tous les consultations
    @GetMapping("/api/consultations")
    public List<Consultation> listeConsultations() {
        return consultationService.listeConsultations();
    }

    // recuperer une consultation ayant un id particulier
    @GetMapping("/api/consultations/{id}")
    public Consultation recupererConsultation(@PathVariable("id") int id) {
        return consultationService.recupererConsultation(id);
    }

    // créer une nouvelle consultation
    @PostMapping("/api/consultations")
    public void creerConsultation(@RequestBody Consultation consultation) {
        Consultation newConsultation = new Consultation();
        newConsultation.setMotif(consultation.getMotif());
        newConsultation.setDateConsultation(consultation.getDateConsultation());
        newConsultation.setIdPatient(consultation.getIdPatient());

        consultationService.creerConsultation(newConsultation);
    }

    // modifier une consultation
    @PutMapping("/api/consultations/{id}")
    public void modifierConsultation(@PathVariable("id") int id, @RequestBody Consultation consultation) {
        consultationService.modifierConsultation(id, consultation);
    }

    // supprimer une consultation
    @DeleteMapping("/api/consultations/{id}")
    public void supprimerConsultation(@PathVariable("id") int id) {
        consultationService.supprimerConsultation(id);
    }

    // rechercher les consultations par leurs noms
    @GetMapping("/api/consultations/rechercher")
    public List<Consultation> rechercherConsultations(@RequestParam String motif) {
        return consultationService.rechercherConsultations(motif);
    }

    // Lignes consultations
    // liste des lignes-consultations
    @GetMapping("/api/consultations/lignes-consultations")
    public List<LigneConsultation> listeLigneConsultation() {
        return consultationService.listeLigneConsultation();
    }

    // liste des lignes-consultations d'une consultation
    @GetMapping("/api/consultations/{idConsultation}/lignes-consultations")
    public List<LigneConsultation> listeLigneConsultationPatient(@PathVariable("idConsultation") int idConsultation) {
        return consultationService.listeLigneConsultationConsultation(idConsultation);
    }

    // creer une ligne-consultation
    @PostMapping("/api/consultations/lignes-consultations")
    public void creerLigneConsultation(@RequestBody LigneConsultation ligneConsultation) {
        LigneConsultation newLigneConsultation = new LigneConsultation();
        newLigneConsultation.setIdConsultation(ligneConsultation.getIdConsultation());
        newLigneConsultation.setIdTraitement(ligneConsultation.getIdTraitement());
        newLigneConsultation.setPosologie(ligneConsultation.getPosologie());
        newLigneConsultation.setUniteTemps(ligneConsultation.getUniteTemps());
        newLigneConsultation.setQuantite(ligneConsultation.getQuantite());

        consultationService.creerLigneConsultation(newLigneConsultation);
    }

    // modifier une ligne-consultation
    @PutMapping("/api/consultations/lignes-consultations/{id}")
    public void modifierLigneConsultation(@PathVariable("id") int id, @RequestBody LigneConsultation ligneConsultation) {
        consultationService.modifierLigneConsultation(id, ligneConsultation);
    }

    // supprimer une ligne-consultation
    @DeleteMapping("/api/consultations/lignes-consultations/{id}")
    public void supprimerLigneConsultation(@PathVariable("id") int id) {
        consultationService.supprimerLigneConsultation(id);
    }
}
