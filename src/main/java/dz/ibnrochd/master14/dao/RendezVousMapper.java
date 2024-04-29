package dz.ibnrochd.master14.dao;

import dz.ibnrochd.master14.model.RendezVous;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RendezVousMapper {
    @Select("SELECT * FROM rendez_vous WHERE idPatient=#{idPatient}")
    List<RendezVous> listeRendezVous(int idPatient);

    @Insert("INSERT INTO rendez_vous(date_rdv, id_patient) VALUES(#{dateRdv}, #{idPatient})")
    void prendreRendezVous(RendezVous rendezVous);

    @Delete("DELETE FROM rendez_vous WHERE id=#{id}")
    void supprimerRendezVous(int id);
}
