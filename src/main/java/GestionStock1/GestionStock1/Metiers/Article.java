package GestionStock1.GestionStock1.Metiers;

import GestionStock1.GestionStock1.Metiers.*;

public class Article {
	private int id_article;
	private String designation;
	private double prix_Unitaire_HT;
	private double ttc ;
	private static double  taux_Tva=25;
	private String categorie;
	 
	public Article(int id_article, String designation, double prix_Unitaire_HT, double ttc, String categorie) {
		super();
		this.id_article = id_article;
		this.designation = designation;
		this.prix_Unitaire_HT = prix_Unitaire_HT;
		this.ttc = ttc;
		this.categorie = categorie;
	}

	public int getId_article() {
		return id_article;
	}

	public void setId_article(int id_article) {
		this.id_article = id_article;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getPrix_Unitaire_HT() {
		return prix_Unitaire_HT;
	}

	public void setPrix_Unitaire_HT(double prix_Unitaire_HT) {
		this.prix_Unitaire_HT = prix_Unitaire_HT;
	}

	public double getTtc() {
		return ttc;
	}

	public void setTtc(double ttc) {
		this.ttc = ttc;
	}

	public static double getTaux_Tva() {
		return taux_Tva;
	}

	public static void setTaux_Tva(double taux_Tva) {
		Article.taux_Tva = taux_Tva;
	}

	public  String getCategorie() {
		return categorie;
	}

	public void setCategorie(String  categorie) {
		this.categorie = categorie;
	}
	
	public double CalculerPrixTTC()
	{
	    return prix_Unitaire_HT * (1 + taux_Tva / 100);
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Article other = (Article) obj;
		if (categorie == null) {
			if (other.categorie != null)
				return false;
		} else if (!categorie.equals(other.categorie))
			return false;
		if (designation == null) {
			if (other.designation != null)
				return false;
		} else if (!designation.equals(other.designation))
			return false;
		if (id_article != other.id_article)
			return false;
		if (Double.doubleToLongBits(prix_Unitaire_HT) != Double.doubleToLongBits(other.prix_Unitaire_HT))
			return false;
		if (Double.doubleToLongBits(ttc) != Double.doubleToLongBits(other.ttc))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Article [id_article=" + id_article + ", designation=" + designation + ", prix_Unitaire_HT="
				+ prix_Unitaire_HT + ", ttc=" + ttc + ", categorie=" + categorie + "]";
	}
	
}
