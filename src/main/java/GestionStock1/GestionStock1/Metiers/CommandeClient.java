package GestionStock1.GestionStock1.Metiers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import GestionStock1.GestionStock1.Metiers.*;


public class CommandeClient {
private int id_commande;
   private String nom_article;
   private String categorie;
   private int quantite;
   
   public CommandeClient(int id_commande, String nom_article, String categorie, int quantite) {
super();
this.id_commande = id_commande;
this.nom_article = nom_article;
this.categorie = categorie;
this.quantite = quantite;
}

//Accesseurs

   public int getId_Commande() {
       return this.id_commande;
   }

   public String getNom_Article() {
       return this.nom_article;
   }

   public String get_Categorie() {
       return this.categorie;
   }

   public int getQuantite() {
       return this.quantite;
   }

   public void setID_Commande(int id_commande) {
       this.id_commande = id_commande;
   }

   public void setNom_Article(String nom_article) {
       this.nom_article = nom_article;
   }

   public void setCategorie(String categorie) {
       this.categorie = categorie;
   }

   public void setQuantite(int quantite) {
       this.quantite = quantite;
   }
}


