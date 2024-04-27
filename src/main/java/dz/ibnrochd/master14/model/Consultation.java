package dz.ibnrochd.master14.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Consultation implements Serializable {

	private static final long serialVersionUID = -3669998604878710274L;

	private int id;
	private String motif;
	private Date dateConsultation;
	private int idPatient;
	private List<Traitement> traitements = new ArrayList<>();

	public Consultation() {}

	public Consultation(int id, String motif, Date dateConsultation, int idPatient) {
		this.id = id;
		this.motif = motif;
		this.dateConsultation = dateConsultation;
		this.idPatient = idPatient;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public Date getDateConsultation() {
		return dateConsultation;
	}

	public void setDateConsultation(Date dateConsultation) {
		this.dateConsultation = dateConsultation;
	}

	public int getIdPatient() {
		return idPatient;
	}

	public void setIdPatient(int idPatient) {
		this.idPatient = idPatient;
	}

	public List<Traitement> getTraitements() {
		return traitements;
	}

	public void setTraitements(List<Traitement> traitements) {
		this.traitements = traitements;
	}
}
