package dz.ibnrochd.master14.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TraitementMapper {
    @Select("SELECT t.nom FROM consultation c, traitement t, ligne_consultation lc WHERE c.id = lc.id_consultation AND t.id = lc.id_traitement AND c.id = 3")
    List<String> rechercherTraitement();
}
