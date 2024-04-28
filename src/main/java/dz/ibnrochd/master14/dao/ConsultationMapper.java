package dz.ibnrochd.master14.dao;

import dz.ibnrochd.master14.model.Consultation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ConsultationMapper {
    @Select("SELECT * FROM consultation WHERE id = 3")
    Consultation rechercherConsultation();
}
