package dz.ibnrochd.master14.dao;

import dz.ibnrochd.master14.model.LigneConsultation;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LigneConsultationMapper {
    @Select("SELECT * FROM ligne_consultation")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "idConsultation", column = "id_consultation"),
            @Result(property = "idTraitement", column = "id_traitement"),
            @Result(property = "posologie", column = "posologie"),
            @Result(property = "uniteTemps", column = "unite_temps"),
            @Result(property = "quantite", column = "quantite")
    })
    List<LigneConsultation> listeLigneConsultation();

    @Select("SELECT * FROM ligne_consultation WHERE id_consultation=#{idConsultation}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "idConsultation", column = "id_consultation"),
            @Result(property = "idTraitement", column = "id_traitement"),
            @Result(property = "posologie", column = "posologie"),
            @Result(property = "uniteTemps", column = "unite_temps"),
            @Result(property = "quantite", column = "quantite")
    })
    List<LigneConsultation> listeLigneConsultationConsultation(int idConsultation);

    @Insert("INSERT INTO ligne_consultation(id_consultation, id_traitement, posologie, unite_temps, quantite) VALUES(#{idConsultation}, #{idTraitement}, #{posologie}, #{uniteTemps}, #{quantite})")
    void creerLigneConsultation(LigneConsultation ligneConsultation);

    @Update("UPDATE ligne_consultation SET posologie=#{ligneConsultation.posologie}, unite_temps=#{ligneConsultation.uniteTemps}, quantite=#{ligneConsultation.quantite} WHERE id=#{id}")
    void modifierLigneConsultation(int id, LigneConsultation ligneConsultation);

    @Delete("DELETE FROM ligne_consultation WHERE id=#{id}")
    void supprimerLigneConsultation(int id);
}
