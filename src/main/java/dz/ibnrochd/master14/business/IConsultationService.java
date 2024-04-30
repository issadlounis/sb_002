package dz.ibnrochd.master14.business;

import dz.ibnrochd.master14.model.Consultation;
import dz.ibnrochd.master14.model.LigneConsultation;

import java.util.List;

public interface IConsultationService {
    // Consultations
    public List<Consultation> listeConsultations();

    public Consultation recupererConsultation(int id);

    public void creerConsultation(Consultation consultation);

    public void modifierConsultation(int id, Consultation consultation);

    public void supprimerConsultation(int id);

    public List<Consultation> rechercherConsultations(String motif);

    // Lignes consultations
    public List<LigneConsultation> listeLigneConsultation();

    // Lignes des consultations d'une consultation
    public List<LigneConsultation> listeLigneConsultationConsultation(int idConsultation);

    public void creerLigneConsultation(LigneConsultation ligneConsultation);

    public void modifierLigneConsultation(int id, LigneConsultation ligneConsultation);

    public void supprimerLigneConsultation(int id);
}
