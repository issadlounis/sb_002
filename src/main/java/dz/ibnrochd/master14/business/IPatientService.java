package dz.ibnrochd.master14.business;

import dz.ibnrochd.master14.model.Patient;

import java.util.List;

public interface IPatientService {
    public List<Patient> listePatients();

    public Patient recupererPatient(int id);

    public void creerPatient(Patient patient);

    public void modifierPatient(int id, Patient patient);

    public void supprimerPatient(int id);

    public List<Patient> rechercherPatients(String nom);
}
