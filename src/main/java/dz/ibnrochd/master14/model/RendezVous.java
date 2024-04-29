package dz.ibnrochd.master14.model;

import java.io.Serializable;
import java.util.Date;

public class RendezVous implements Serializable {

	private static final long serialVersionUID = -7275578697948165342L;

    private int id;

    private Date dateRdv;

	private int idPatient;

    //////////////////////////////////////////////
    
    public RendezVous() {}

	public RendezVous(int id, Date dateRdv, int idPatient) {
		super();
		this.id = id;
		this.dateRdv = dateRdv;
		this.idPatient = idPatient;
	}

	///////////////////////////////////////////////
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateRdv() {
		return dateRdv;
	}

	public void setDateRdv(Date dateRdv) {
		this.dateRdv = dateRdv;
	}

	public int getIdPatient() { return idPatient; }

	public void setIdPatient(int idPatient) {
		this.idPatient = idPatient;
	}
    
    
}
