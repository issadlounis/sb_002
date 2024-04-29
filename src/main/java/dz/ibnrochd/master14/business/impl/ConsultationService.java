package dz.ibnrochd.master14.business.impl;

import dz.ibnrochd.master14.business.IConsultationService;
import dz.ibnrochd.master14.dao.ConsultationMapper;
import dz.ibnrochd.master14.dao.LigneConsultationMapper;
import dz.ibnrochd.master14.model.Consultation;
import dz.ibnrochd.master14.model.LigneConsultation
        ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultationService implements IConsultationService {
    @Autowired
    ConsultationMapper consultationMapper;

    @Autowired
    LigneConsultationMapper ligneConsultationMapper;

    // Consultations
    @Override
    public List<Consultation> listeConsultations() {
        return consultationMapper.listeConsultations();
    }

    @Override
    public Consultation recupererConsultation(int id) {
        return consultationMapper.recupererConsultation(id);
    }

    @Override
    public void creerConsultation(Consultation consultation) {
        consultationMapper.creerConsultation(consultation);
    }

    @Override
    public void modifierConsultation(int id, Consultation consultation) {
        consultationMapper.modifierConsultation(id, consultation);
    }

    @Override
    public void supprimerConsultation(int id) {
        consultationMapper.supprimerConsultation(id);
    }

    @Override
    public List<Consultation> rechercherConsultations(String motif) {
        return consultationMapper.rechercherConsultations(motif);
    }

    // Lignes consultations
    @Override
    public List<LigneConsultation> listeLigneConsultation() {
        return ligneConsultationMapper.listeLigneConsultation();
    }

    @Override
    public List<LigneConsultation> listeLigneConsultationConsultation(int idConsultation) {
        return ligneConsultationMapper.listeLigneConsultationConsultation(idConsultation);
    }

    @Override
    public void creerLigneConsultation(LigneConsultation ligneConsultation) {
        ligneConsultationMapper.creerLigneConsultation(ligneConsultation);
    }

    @Override
    public void modifierLigneConsultation(int id, LigneConsultation ligneConsultation) {
        ligneConsultationMapper.modifierLigneConsultation(id, ligneConsultation);
    }

    @Override
    public void supprimerLigneConsultation(int id) {
        ligneConsultationMapper.supprimerLigneConsultation(id);
    }
}
