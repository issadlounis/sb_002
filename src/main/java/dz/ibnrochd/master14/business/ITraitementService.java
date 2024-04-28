package dz.ibnrochd.master14.business;

import dz.ibnrochd.master14.model.Traitement;

import java.util.List;

public interface ITraitementService {
    public List<Traitement> listeTraitements();

    public Traitement recupererTraitement(int id);

    public void creerTraitement(Traitement patient);

    public void modifierTraitement(int id, Traitement patient);

    public void supprimerTraitement(int id);

    public List<Traitement> rechercherTraitements(String nom);
}
