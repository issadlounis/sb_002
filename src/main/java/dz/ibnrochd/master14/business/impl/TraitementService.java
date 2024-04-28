package dz.ibnrochd.master14.business.impl;

import dz.ibnrochd.master14.business.ITraitementService;
import dz.ibnrochd.master14.dao.TraitementMapper;
import dz.ibnrochd.master14.model.Traitement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TraitementService implements ITraitementService {
    @Autowired
    TraitementMapper traitementMapper;

    @Override
    public List<Traitement> listeTraitements() {
        return traitementMapper.listeTraitements();
    }

    @Override
    public Traitement recupererTraitement(int id) {
        return traitementMapper.recupererTraitement(id);
    }

    @Override
    public void creerTraitement(Traitement traitement) {
        traitementMapper.creerTraitement(traitement);
    }

    @Override
    public void modifierTraitement(int id, Traitement traitement) {
        traitementMapper.modifierTraitement(id, traitement);
    }

    @Override
    public void supprimerTraitement(int id) {
        traitementMapper.supprimerTraitement(id);
    }

    @Override
    public List<Traitement> rechercherTraitements(String nom) {
        return traitementMapper.rechercherTraitements(nom);
    }
}
