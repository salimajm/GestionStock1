package GestionStock1.GestionStock1.Metiers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import GestionStock1.GestionStock1.Metiers.*;


public class CommandeClient {
	private String  code;
	private Date dateCommandeClient;
	private Client client;
	List<LigneCommandeClient> ligneCommandeClients = new ArrayList<LigneCommandeClient>();
	public CommandeClient(String code, Date dateCommandeClient, Client client,
			List<LigneCommandeClient> ligneCommandeClients) {
		super();
		this.code = code;
		this.dateCommandeClient = dateCommandeClient;
		this.client = client;
		this.ligneCommandeClients = ligneCommandeClients;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Date getDateCommandeClient() {
		return dateCommandeClient;
	}
	public void setDateCommandeClient(Date dateCommandeClient) {
		this.dateCommandeClient = dateCommandeClient;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public List<LigneCommandeClient> getLigneCommandeClients() {
		return ligneCommandeClients;
	}
	public void setLigneCommandeClients(List<LigneCommandeClient> ligneCommandeClients) {
		this.ligneCommandeClients = ligneCommandeClients;
	}

	public void addLigne(LigneCommandeClient l) {
	    ligneCommandeClients.add(l);
	}
}


