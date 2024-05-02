package dz.ibnrochd.master14.business.impl;

import dz.ibnrochd.master14.business.IPatientService;
import dz.ibnrochd.master14.dao.PatientMapper;
import dz.ibnrochd.master14.dao.RendezVousMapper;
import dz.ibnrochd.master14.model.Patient;
import dz.ibnrochd.master14.model.RendezVous;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
public class PatientService implements IPatientService {
    @Autowired
    PatientMapper patientMapper;

    @Autowired
    RendezVousMapper rendezVousMapper;

    // Patients
    @Override
    public List<Patient> listePatients() {
        return patientMapper.listePatients();
    }

    @Override
    public Patient recupererPatient(int id) {
        return patientMapper.recupererPatient(id);
    }

    @Override
    public ResponseEntity<?> creerPatient(Patient patient) {
        var dateNaissancePatient = patient.getDateNaissance();
        LocalDate today = LocalDate.now();
        var age = Period.between(dateNaissancePatient, today).getYears();

        if(age < 18) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("L'age du patient doit dépasser 18 ans");
        }

        patientMapper.creerPatient(patient);
        return ResponseEntity.noContent().build();
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

    // Rendez-vous
    @Override
    public List<RendezVous> listeRendezVous() {
        return rendezVousMapper.listeRendezVous();
    }

    @Override
    public List<RendezVous> listeRendezVousPatient(int idPatient) {
        return rendezVousMapper.listeRendezVousPatient(idPatient);
    }

    @Override
    public void prendreRendezVous(RendezVous rendezVous) {
        rendezVousMapper.prendreRendezVous(rendezVous);
    }

    @Override
    public void modifierRendezVous(int id, RendezVous rendezVous) {
        rendezVousMapper.modifierRendezVous(id, rendezVous);
    }

    @Override
    public void supprimerRendezVous(int id) {
        rendezVousMapper.supprimerRendezVous(id);
    }
}
