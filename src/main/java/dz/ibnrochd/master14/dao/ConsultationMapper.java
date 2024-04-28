package dz.ibnrochd.master14.dao;

import dz.ibnrochd.master14.model.Consultation;
import dz.ibnrochd.master14.model.Consultation;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ConsultationMapper {
    @Select("SELECT * FROM consultation")
    List<Consultation> listeConsultations();

    @Select("SELECT * FROM consultation WHERE id=#{id}")
    Consultation recupererConsultation(int id);

    @Insert("INSERT INTO consultation(motif, date_consultation, id_patient) VALUES(#{motif}, #{dateConsultation}, #{idPatient})")
    void creerConsultation(Consultation consultation);

    @Update("UPDATE consultation SET motif=#{consultation.motif}, date_consultation=#{consultation.dateConsultation}, id_patient=#{consultation.idPatient} WHERE id=#{id}")
    void modifierConsultation(int id, Consultation consultation);

    @Delete("DELETE FROM consultation WHERE id=#{id}")
    void supprimerConsultation(int id);

    @Select("SELECT * FROM consultation WHERE LOWER(motif) LIKE CONCAT('%', LOWER(#{motif}), '%')")
    List<Consultation> rechercherConsultations(@Param("motif") String motif);
}
