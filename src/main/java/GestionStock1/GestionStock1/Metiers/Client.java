package GestionStock1.GestionStock1.Metiers;


import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//import GestionStock1.Metiers.CommandeClient;

public class Client {
	private String  id_Client;
	private String  nom_Client;
	private String prenom_Client;
	private String email ;
	private String adresse;
	private int telephone;
	private String sexe;
	private int cin;
	private LocalDate dateNaissance;
	private String Ville;
	List<CommandeClient> commandeClients = new ArrayList<CommandeClient>();


	public Client() {
		super();
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Ville == null) ? 0 : Ville.hashCode());
		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
		result = prime * result + cin;
		result = prime * result + ((commandeClients == null) ? 0 : commandeClients.hashCode());
		result = prime * result + ((dateNaissance == null) ? 0 : dateNaissance.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id_Client == null) ? 0 : id_Client.hashCode());
		result = prime * result + ((nom_Client == null) ? 0 : nom_Client.hashCode());
		result = prime * result + ((prenom_Client == null) ? 0 : prenom_Client.hashCode());
		result = prime * result + ((sexe == null) ? 0 : sexe.hashCode());
		result = prime * result + telephone;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (Ville == null) {
			if (other.Ville != null)
				return false;
		} else if (!Ville.equals(other.Ville))
			return false;
		if (adresse == null) {
			if (other.adresse != null)
				return false;
		} else if (!adresse.equals(other.adresse))
			return false;
		if (cin != other.cin)
			return false;
		if (commandeClients == null) {
			if (other.commandeClients != null)
				return false;
		} else if (!commandeClients.equals(other.commandeClients))
			return false;
		if (dateNaissance == null) {
			if (other.dateNaissance != null)
				return false;
		} else if (!dateNaissance.equals(other.dateNaissance))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id_Client == null) {
			if (other.id_Client != null)
				return false;
		} else if (!id_Client.equals(other.id_Client))
			return false;
		if (nom_Client == null) {
			if (other.nom_Client != null)
				return false;
		} else if (!nom_Client.equals(other.nom_Client))
			return false;
		if (prenom_Client == null) {
			if (other.prenom_Client != null)
				return false;
		} else if (!prenom_Client.equals(other.prenom_Client))
			return false;
		if (sexe == null) {
			if (other.sexe != null)
				return false;
		} else if (!sexe.equals(other.sexe))
			return false;
		if (telephone != other.telephone)
			return false;
		return true;
	}


	


	@Override
	public String toString() {
		return "Client:id_Client="+id_Client + ",nom_Client=" + nom_Client + ",prenom_Client=" +prenom_Client+ ",adresse=" + adresse + ",telephone=" + telephone + ",sexe=" + sexe + ",CIN=" + cin + ",Ville="
				+ Ville+"]\n\"";
	}


	public Client(String id_Client, String nom_Client, String prenom_Client, String email, String adresse, int telephone,
			String sexe, int cin, LocalDate dateNaissance, String ville, List<CommandeClient> commandeClients) {
		super();
		this.id_Client = id_Client;
		this.nom_Client = nom_Client;
		this.prenom_Client = prenom_Client;
		this.email = email;
		this.adresse = adresse;
		this.telephone = telephone;
		this.sexe = sexe;
		this.cin = cin;
		this.dateNaissance = dateNaissance;
		this.Ville = ville;
		this.commandeClients = commandeClients;
	}


	public Client(String id_Client, String nom_Client, String prenom_Client, String email, String adresse, int telephone,
			String sexe, int cin, LocalDate dateNaissance, String ville) {
		super();
		this.id_Client = id_Client;
		this.nom_Client = nom_Client;
		this.prenom_Client = prenom_Client;
		this.email = email;
		this.adresse = adresse;
		this.telephone = telephone;
		this.sexe = sexe;
		this.cin = cin;
		this.dateNaissance = dateNaissance;
		Ville = ville;
	}





	public String getId_Client() {
		return id_Client;
	}


	public void setId_Client(String id_Client) {
		this.id_Client = id_Client;
	}


	public String getNom_Client() {
		return nom_Client;
	}


	public void setNom_Client(String nom_Client) {
		this.nom_Client = nom_Client;
	}


	public String getPrenom_Client() {
		return prenom_Client;
	}


	public void setPrenom_Client(String prenom_Client) {
		this.prenom_Client = prenom_Client;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public int getTelephone() {
		return telephone;
	}


	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}


	public String getSexe() {
		return sexe;
	}


	public void setSexe(String sexe) {
		this.sexe = sexe;
	}


	public int getCin() {
		return cin;
	}


	public void setCin(int cin) {
		this.cin = cin;
	}


	public LocalDate getDateNaissance() {
		return dateNaissance;
	}


	public Client(String id_Client) {
		super();
		this.id_Client = id_Client;
	}


	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}


	public String getVille() {
		return Ville;
	}


	public void setVille(String ville) {
		Ville = ville;
	}


	public List<CommandeClient> getCommandeClients() {
		return commandeClients;
	}


	public void setCommandeClients(List<CommandeClient> commandeClients) {
		this.commandeClients = commandeClients;
	}

	public void addCommande(CommandeClient c){
		commandeClients.add(c);
	}
}
