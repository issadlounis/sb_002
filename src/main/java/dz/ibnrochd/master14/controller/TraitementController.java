package dz.ibnrochd.master14.controller;

import dz.ibnrochd.master14.Sb002Application;
import dz.ibnrochd.master14.business.impl.TraitementService;
import dz.ibnrochd.master14.model.Traitement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/traitements")
public class TraitementController {
    @Autowired
    TraitementService traitementService;

    // récupérer la liste de tous les traitements
    @GetMapping
    public List<Traitement> listeTraitements() {
        return traitementService.listeTraitements();
    }

    // recuperer un traitement ayant un id particulier
    @GetMapping("/{id}")
    public Traitement recupererTraitement(@PathVariable("id") int id) {
        return traitementService.recupererTraitement(id);
    }

    // créer un nouveau traitement
    @PostMapping("/")
    public void creerTraitement(@RequestBody Traitement traitement) {
        Traitement newTraitement = new Traitement();
        newTraitement.setNom(traitement.getNom());

        traitementService.creerTraitement(newTraitement);
    }

    // modifier un traitement
    @PutMapping("/{id}")
    public void modifierTraitement(@PathVariable("id") int id, @RequestBody Traitement traitement) {
        traitementService.modifierTraitement(id, traitement);
    }

    // supprimer un traitement
    @DeleteMapping("/{id}")
    public void supprimerTraitement(@PathVariable("id") int id) {
        traitementService.supprimerTraitement(id);
    }

    // rechercher les traitements par leurs noms
    @GetMapping("/rechercher")
    public List<Traitement> rechercherTraitements(@RequestParam String nom) {
        return traitementService.rechercherTraitements(nom);
    }
}
