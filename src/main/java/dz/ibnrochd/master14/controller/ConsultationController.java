package dz.ibnrochd.master14.controller;

import dz.ibnrochd.master14.business.impl.ConsultationService;
import dz.ibnrochd.master14.model.Consultation;
import dz.ibnrochd.master14.model.LigneConsultation;
import dz.ibnrochd.master14.model.RendezVous;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultations")
public class ConsultationController {
    @Autowired
    ConsultationService consultationService;

    // Consultations
    // récupérer la liste de tous les consultations
    @GetMapping
    public List<Consultation> listeConsultations() {
        return consultationService.listeConsultations();
    }

    // recuperer une consultation ayant un id particulier
    @GetMapping("/{id}")
    public Consultation recupererConsultation(@PathVariable("id") int id) {
        return consultationService.recupererConsultation(id);
    }

    // créer une nouvelle consultation
    @PostMapping
    public void creerConsultation(@RequestBody Consultation consultation) {
        Consultation newConsultation = new Consultation();
        newConsultation.setMotif(consultation.getMotif());
        newConsultation.setDateConsultation(consultation.getDateConsultation());
        newConsultation.setIdPatient(consultation.getIdPatient());

        consultationService.creerConsultation(newConsultation);
    }

    // modifier une consultation
    @PutMapping("/{id}")
    public void modifierConsultation(@PathVariable("id") int id, @RequestBody Consultation consultation) {
        consultationService.modifierConsultation(id, consultation);
    }

    // supprimer une consultation
    @DeleteMapping("/{id}")
    public void supprimerConsultation(@PathVariable("id") int id) {
        consultationService.supprimerConsultation(id);
    }

    // rechercher les consultations par leurs noms
    @GetMapping("/rechercher")
    public List<Consultation> rechercherConsultations(@RequestParam String motif) {
        return consultationService.rechercherConsultations(motif);
    }

    // Lignes consultations
    // liste des lignes-consultations
    @GetMapping("/lignes-consultations")
    public List<LigneConsultation> listeLigneConsultation() {
        return consultationService.listeLigneConsultation();
    }

    // liste des lignes-consultations d'une consultation
    @GetMapping("/{idConsultation}/lignes-consultations")
    public List<LigneConsultation> listeRendezVousPatient(@PathVariable("idConsultation") int idConsultation) {
        return consultationService.listeLigneConsultationConsultation(idConsultation);
    }

    // creer une ligne-consultation
    @PostMapping("/lignes-consultations")
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
    @PutMapping("/lignes-consultations/{id}")
    public void modifierLigneConsultation(@PathVariable("id") int id, @RequestBody LigneConsultation ligneConsultation) {
        consultationService.modifierLigneConsultation(id, ligneConsultation);
    }

    // supprimer une ligne-consultation
    @DeleteMapping("/lignes-consultations/{id}")
    public void supprimerLigneConsultation(@PathVariable("id") int id) {
        consultationService.supprimerLigneConsultation(id);
    }
}
