package dz.ibnrochd.master14.view;

import dz.ibnrochd.master14.business.impl.ConsultationService;
import dz.ibnrochd.master14.business.impl.PatientService;
import dz.ibnrochd.master14.business.impl.TraitementService;
import dz.ibnrochd.master14.model.Patient;
import dz.ibnrochd.master14.model.Traitement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Controller
public class Controller {
    private final PatientService patientService;
    private final TraitementService traitementService;
    private final ConsultationService consultationService;

    @Autowired
    public Controller(PatientService patientService, TraitementService traitementService, ConsultationService consultationService) {
        this.patientService = patientService;
        this.traitementService = traitementService;
        this.consultationService = consultationService;
    }

    //Patients
    // récupérer la liste de tous les patients
    @GetMapping
    public String listePatients(Model model) {
        List<Patient> patients = patientService.listePatients();
        model.addAttribute("patients", patients);

        // Return the name of the Thymeleaf template
        return "liste-patients";
    }

    // créer un nouveau patient
    @PostMapping
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

    // Traitements
    // récupérer la liste de tous les traitements
    @GetMapping
    public List<Traitement> listeTraitements() {
        return traitementService.listeTraitements();
    }

    // créer un nouveau traitement
    @PostMapping
    public void creerTraitement(@RequestBody Traitement traitement) {
        Traitement newTraitement = new Traitement();
        newTraitement.setNom(traitement.getNom());

        traitementService.creerTraitement(newTraitement);
    }
}
