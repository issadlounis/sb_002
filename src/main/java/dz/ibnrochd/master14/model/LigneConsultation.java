package dz.ibnrochd.master14.model;

import java.io.Serializable;

public class LigneConsultation implements Serializable {

	private static final long serialVersionUID = -1882485395538957648L;

	private int id;
	private int idConsultation;
	private int idTraitement;
	private String posologie;
	private String uniteTemps;
	private String quantite;

	public LigneConsultation() {}

	public LigneConsultation(int id, int idConsultation, int idTraitement, String posologie, String uniteTemps, String quantite) {
		this.id = id;
		this.idConsultation = idConsultation;
		this.idTraitement = idTraitement;
		this.posologie = posologie;
		this.uniteTemps = uniteTemps;
		this.quantite = quantite;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdConsultation() {
		return idConsultation;
	}

	public void setIdConsultation(int idConsultation) {
		this.idConsultation = idConsultation;
	}

	public int getIdTraitement() {
		return idTraitement;
	}

	public void setIdTraitement(int idTraitement) {
		this.idTraitement = idTraitement;
	}

	public String getPosologie() {
		return posologie;
	}

	public void setPosologie(String posologie) {
		this.posologie = posologie;
	}

	public String getUniteTemps() {
		return uniteTemps;
	}

	public void setUniteTemps(String uniteTemps) {
		this.uniteTemps = uniteTemps;
	}

	public String getQuantite() {
		return quantite;
	}

	public void setQuantite(String quantite) {
		this.quantite = quantite;
	}
}
