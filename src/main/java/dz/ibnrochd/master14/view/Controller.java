package dz.ibnrochd.master14.view;

import dz.ibnrochd.master14.business.impl.ConsultationService;
import dz.ibnrochd.master14.business.impl.PatientService;
import dz.ibnrochd.master14.business.impl.TraitementService;
import dz.ibnrochd.master14.model.Patient;
import dz.ibnrochd.master14.model.Traitement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/patients")
    public String listePatients(Model model) {
        List<Patient> patients = patientService.listePatients();
        model.addAttribute("patients", patients);

        return "liste-patients";
    }

    // créer un nouveau patient
    @PostMapping("/patients")
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
    @GetMapping("/traitements")
    public String listeTraitements(Model model) {
        List<Traitement> traitements = traitementService.listeTraitements();
        model.addAttribute("traitements", traitements);

        return "liste-traitements";
    }

    // créer un nouveau traitement
    @PostMapping("/traitements")
    public void creerTraitement(@RequestBody Traitement traitement) {
        Traitement newTraitement = new Traitement();
        newTraitement.setNom(traitement.getNom());

        traitementService.creerTraitement(newTraitement);
    }
}
