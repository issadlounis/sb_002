package dz.ibnrochd.master14.dao;

import org.apache.ibatis.annotations.*;

import dz.ibnrochd.master14.model.Patient;

import java.util.List;

@Mapper
public interface PatientMapper {
    @Select("SELECT * FROM patient")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "nom", column = "nom"),
            @Result(property = "prenom", column = "prenom"),
            @Result(property = "sexe", column = "sexe"),
            @Result(property = "dateNaissance", column = "date_naissance"),
            @Result(property = "numeroTelephone", column = "numero_telephone"),
            @Result(property = "adresse", column = "adresse"),
    })
    List<Patient> listePatients();

    @Select("SELECT * FROM patient WHERE id=#{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "nom", column = "nom"),
            @Result(property = "prenom", column = "prenom"),
            @Result(property = "sexe", column = "sexe"),
            @Result(property = "dateNaissance", column = "date_naissance"),
            @Result(property = "numeroTelephone", column = "numero_telephone"),
            @Result(property = "adresse", column = "adresse"),
    })
    Patient recupererPatient(int id);

    @Insert("INSERT INTO patient(nom, prenom, sexe, date_naissance, numero_telephone, adresse) VALUES(#{nom}, #{prenom}, #{sexe}, #{dateNaissance}, #{numeroTelephone}, #{adresse})")
    void creerPatient(Patient patient);

    @Update("UPDATE patient SET nom=#{patient.nom}, prenom=#{patient.prenom}, sexe=#{patient.sexe}, date_naissance=#{patient.dateNaissance}, numero_telephone=#{patient.numeroTelephone}, adresse=#{patient.adresse} WHERE id=#{id}")
    void modifierPatient(int id, Patient patient);

    @Delete("DELETE FROM patient WHERE id=#{id}")
    void supprimerPatient(int id);

    @Select("SELECT * FROM patient WHERE LOWER(nom) LIKE CONCAT('%', LOWER(#{nom}), '%')")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "nom", column = "nom"),
            @Result(property = "prenom", column = "prenom"),
            @Result(property = "sexe", column = "sexe"),
            @Result(property = "dateNaissance", column = "date_naissance"),
            @Result(property = "numeroTelephone", column = "numero_telephone"),
            @Result(property = "adresse", column = "adresse"),
    })
    List<Patient> rechercherPatients(@Param("nom") String nom);

	// TODO ajouter la signature d'une méthode pour rechercher des patients par leurs noms (convention Spring Data)
}
