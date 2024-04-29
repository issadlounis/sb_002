package dz.ibnrochd.master14.dao;

import dz.ibnrochd.master14.model.RendezVous;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RendezVousMapper {
    @Select("SELECT * FROM rendez_vous")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "dateRdv", column = "date_rdv"),
            @Result(property = "idPatient", column = "id_patient")
    })
    List<RendezVous> listeRendezVous();

    @Select("SELECT * FROM rendez_vous WHERE idPatient=#{idPatient}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "dateRdv", column = "date_rdv"),
            @Result(property = "idPatient", column = "id_patient")
    })
    List<RendezVous> listeRendezVousPatient(int idPatient);

    @Insert("INSERT INTO rendez_vous(date_rdv, id_patient) VALUES(#{dateRdv}, #{idPatient})")
    void prendreRendezVous(RendezVous rendezVous);

    @Delete("DELETE FROM rendez_vous WHERE id=#{id}")
    void supprimerRendezVous(int id);
}
