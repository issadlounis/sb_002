package dz.ibnrochd.master14.business.impl;

import dz.ibnrochd.master14.business.IPatientService;
import dz.ibnrochd.master14.dao.PatientMapper;
import dz.ibnrochd.master14.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService implements IPatientService {
    @Autowired
    PatientMapper patientMapper;

    @Override
    public List<Patient> listePatients() {
        return patientMapper.listePatients();
    }

    @Override
    public Patient recupererPatient(int id) {
        return patientMapper.recupererPatient(id);
    }

    @Override
    public void creerPatient(Patient patient) {
        patientMapper.creerPatient(patient);
    }

    @Override
    public void modifierPatient(int id, Patient patient) {
        patientMapper.modifierPatient(id, patient);
    }

    @Override
    public void supprimerPatient(int id) {
        patientMapper.supprimerPatient(id);
    }

    @Override
    public List<Patient> rechercherPatients(String nom) {
        return patientMapper.rechercherPatients(nom);
    }
}
