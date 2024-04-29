package dz.ibnrochd.master14.controller;

import dz.ibnrochd.master14.Sb002Application;
import dz.ibnrochd.master14.business.impl.ConsultationService;
import dz.ibnrochd.master14.model.Consultation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultations")
public class ConsultationController {
    @Autowired
    ConsultationService consultationService;

    // récupérer la liste de tous les consultations
    @GetMapping
    public List<Consultation> listeConsultations() {
        return consultationService.listeConsultations();
    }

    // recuperer un consultation ayant un id particulier
    @GetMapping("/{id}")
    public Consultation recupererConsultation(@PathVariable("id") int id) {
        return consultationService.recupererConsultation(id);
    }

    // créer un nouveau consultation
    @PostMapping("/")
    public void creerConsultation(@RequestBody Consultation consultation) {
        Consultation newConsultation = new Consultation();
        newConsultation.setMotif(consultation.getMotif());
        newConsultation.setDateConsultation(consultation.getDateConsultation());
        newConsultation.setIdPatient(consultation.getIdPatient());

        consultationService.creerConsultation(newConsultation);
    }

    // modifier un consultation
    @PutMapping("/{id}")
    public void modifierConsultation(@PathVariable("id") int id, @RequestBody Consultation consultation) {
        consultationService.modifierConsultation(id, consultation);
    }

    // supprimer un consultation
    @DeleteMapping("/{id}")
    public void supprimerConsultation(@PathVariable("id") int id) {
        consultationService.supprimerConsultation(id);
    }

    // rechercher les consultations par leurs noms
    @GetMapping("/rechercher")
    public List<Consultation> rechercherConsultations(@RequestParam String motif) {
        return consultationService.rechercherConsultations(motif);
    }
}
