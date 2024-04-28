package dz.ibnrochd.master14.dao;

import dz.ibnrochd.master14.model.Traitement;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TraitementMapper {
    @Select("SELECT * FROM traitement")
    List<Traitement> listeTraitements();

    @Select("SELECT * FROM traitement WHERE id=#{id}")
    Traitement recupererTraitement(int id);

    @Insert("INSERT INTO traitement(nom) VALUES(#{nom})")
    void creerTraitement(Traitement traitement);

    @Update("UPDATE traitement SET nom=#{traitement.nom} WHERE id=#{id}")
    void modifierTraitement(int id, Traitement traitement);

    @Delete("DELETE FROM traitement WHERE id=#{id}")
    void supprimerTraitement(int id);

    @Select("SELECT * FROM traitement WHERE LOWER(nom) LIKE CONCAT('%', LOWER(#{nom}), '%')")
    List<Traitement> rechercherTraitements(@Param("nom") String nom);
}
