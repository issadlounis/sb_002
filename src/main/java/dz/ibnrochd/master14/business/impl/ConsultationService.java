package dz.ibnrochd.master14.business.impl;

import dz.ibnrochd.master14.business.IConsultationService;
import dz.ibnrochd.master14.dao.ConsultationMapper;
import dz.ibnrochd.master14.model.Consultation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultationService implements IConsultationService {
    @Autowired
    ConsultationMapper consultationMapper;

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
}
