package dz.ibnrochd.master14.dao;

import org.apache.ibatis.annotations.*;

import dz.ibnrochd.master14.model.Patient;

import java.util.List;

@Mapper
public interface PatientMapper {
    @Select("SELECT * FROM patient")
    List<Patient> listePatients();

    @Select("SELECT * FROM patient WHERE nom LIKE '%Yahi%'")
    List<Patient> rechercherPatients();

    @Insert("INSERT INTO patient(nom, prenom, sexe, date_naissance, numero_telephone, adresse) VALUES(#{nom}, #{prenom}, #{sexe}, #{dateNaissance}, #{numeroTelephone}, #{adresse})")
    void savePatient(Patient patient);

	// TODO ajouter la signature d'une méthode pour rechercher des patients par leurs noms (convention Spring Data)
}
