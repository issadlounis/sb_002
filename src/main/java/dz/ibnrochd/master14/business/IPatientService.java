package dz.ibnrochd.master14.business;

import dz.ibnrochd.master14.model.Patient;
import dz.ibnrochd.master14.model.RendezVous;

import java.util.List;

public interface IPatientService {
    // Patients
    public List<Patient> listePatients();

    public Patient recupererPatient(int id);

    public void creerPatient(Patient patient);

    public void modifierPatient(int id, Patient patient);

    public void supprimerPatient(int id);

    public List<Patient> rechercherPatients(String nom);

    // Rendez-vous
    public List<RendezVous> listeRendezVous();

    public List<RendezVous> listeRendezVousPatient(int idPatient);

    public void prendreRendezVous(RendezVous rendezVous);

    public void supprimerRendezVous(int id);
}
