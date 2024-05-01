package dz.ibnrochd.master14.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Patient implements Serializable {

	private static final long serialVersionUID = -3415388341943341473L;

    private int id;

    private String nom;

    private String prenom;

    private String sexe;

    private LocalDate dateNaissance;

    private String numeroTelephone;

    private String adresse;

    private List<Consultation> consultations = new ArrayList<>();

    private List<RendezVous> rendezVous = new ArrayList<>();
    
    /////////////////////////////////////////////////////////
    
    public Patient() {}

	public Patient(int id, String nom, String prenom, String sexe, LocalDate dateNaissance, String numeroTelephone,
			String adresse) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.dateNaissance = dateNaissance;
		this.numeroTelephone = numeroTelephone;
		this.adresse = adresse;
	}
	
	//////////////////////////////////////////////////////

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getNumeroTelephone() {
		return numeroTelephone;
	}

	public void setNumeroTelephone(String numeroTelephone) {
		this.numeroTelephone = numeroTelephone;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public List<Consultation> getConsultations() {
		return consultations;
	}

	public void setConsultations(List<Consultation> consultations) {
		this.consultations = consultations;
	}

	public List<RendezVous> getRendezVous() {
		return rendezVous;
	}

	public void setRendezVous(List<RendezVous> rendezVous) {
		this.rendezVous = rendezVous;
	}

	@Override
	public String toString() {
		return "Patient{id=" + id +
				", nom='" + nom + '\'' +
				", prenom='" + prenom + '\'' +
				", sexe='" + sexe + '\'' +
				", dateNaissance='" + dateNaissance + '\'' +
				", numeroTelephone='" + numeroTelephone + '\'' +
				", adresse='" + adresse +
				'}';
	}

}
