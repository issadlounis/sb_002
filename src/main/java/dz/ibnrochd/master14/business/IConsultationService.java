package dz.ibnrochd.master14.business;

import dz.ibnrochd.master14.model.Consultation;

import java.util.List;

public interface IConsultationService {
    public List<Consultation> listeConsultations();

    public Consultation recupererConsultation(int id);

    public void creerConsultation(Consultation consultation);

    public void modifierConsultation(int id, Consultation consultation);

    public void supprimerConsultation(int id);

    public List<Consultation> rechercherConsultations(String motif);
}
