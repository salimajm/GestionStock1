package GestionStock1.GestionStock1.Metiers;

public class Fournisseur {
    int id_fournisseur;
    String nom,adresse;

   
   
    public Fournisseur() {
		super();
	}

	public Fournisseur(int id_fournisseur, String nom, String adresse) {
super();
this.id_fournisseur = id_fournisseur;
this.nom = nom;
this.adresse = adresse;
}

public Fournisseur(int id_fournisseur) {
		super();
		this.id_fournisseur = id_fournisseur;
	}

public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

   

    public int getId_fournisseur() {
        return id_fournisseur;
    }

    public void setId_fournisseur(int id_fournisseur) {
        this.id_fournisseur = id_fournisseur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
   
   
}
