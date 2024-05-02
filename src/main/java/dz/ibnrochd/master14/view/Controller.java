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

    // afficher le formulaire pour ajouter un patient
    @GetMapping("/patients/ajouter-patient")
    public String afficherAjouterPatient(Model model) {
        model.addAttribute("patient", new Patient());
        return "ajouter-patient";
    }

    // créer un nouveau patient
    @PostMapping("/patients/ajouter-patient")
    public String creerPatient(@ModelAttribute Patient patient, Model model) {
        var res = patientService.creerPatient(patient);

        if(res.hasBody()) {
            model.addAttribute("message", res.getBody());
            return "ajouter-patient";
        }

        return "redirect:/patients";
    }

    // afficher le formulaire pour modifier un patient
    @GetMapping("/patients/modifier-patient/{id}")
    public String modifierAjouterPatient(@PathVariable("id") int id, Model model) {
        Patient patient = patientService.recupererPatient(id);

        model.addAttribute("patient", patient);
        return "modifier-patient";
    }

    // modifier un patient
    @PostMapping("/patients/modifier-patient/{id}")
    public String modifierPatient(@PathVariable("id") int id, @ModelAttribute Patient patient) {
        patientService.modifierPatient(id, patient);

        return "redirect:/patients";
    }

    // supprimer un patient
    @PostMapping("/patients/supprimer-patient/{id}")
    public String supprimerPatient(@PathVariable int id) {
        patientService.supprimerPatient(id);

        return "redirect:/patients";
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
