package GestionStock1.GestionStock1.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import GestionStock1.GestionStock1.Metiers.Article;
import GestionStock1.GestionStock1.Metiers.Client;

public class ArticleDAO {
	public void save(Article c) {
        int n=0;
        Connection cnx= SConnection.getInstance();
        PreparedStatement st;
        try {
            st=cnx.prepareStatement("update article set designation= ?,prix_Unitaire_HT=?,ttc=?categorie=? where id_article=?");
            st.setString(1,c.getDesignation());
            st.setDouble(2, c.getPrix_Unitaire_HT()  );
            st.setDouble(3, c.getTtc()  );
            st.setString(4, c.getCategorie());
            n= st.executeUpdate();//n: nbre de lignes modifiées
            st.close();
            if(n==1) {
                System.out.println("Mise à jour du article avec succès ");
            }
        } catch (SQLException e) {
            System.out.println("Mise à jour du article a échoué ");
        }
        if(n==0)
            {try {
            String rq2="insert into article(id_article, designation,prix_Unitaire_HT,ttc,categorie) values (?,?,?,?,?)";
            st=cnx.prepareStatement(rq2);           
            st.setInt(1,c.getId_article());
            st.setString(2, c.getDesignation() );   
            st.setDouble(3, c.getPrix_Unitaire_HT() );  
            st.setDouble(4, c.getTtc() );   
            st.setString(5, c.getCategorie() ); 
            n= st.executeUpdate();
            System.out.println("Ajout du article avec succès ");
            st.close();
            } catch (SQLException e) {
                System.out.println("L'ajout du article a échoué ");
            }
            }
    }
    
        //*****************************************************************
        public Collection<Article> getArticles() {
            String rq="select * from article";
            Collection<Article> lesarticles= new ArrayList<Article>();
            Connection cnx= SConnection.getInstance();
            PreparedStatement st=null;
            Article a = null;
            try {
            st=cnx.prepareStatement(rq);
            ResultSet res = st.executeQuery();
            while (res.next()) {
    
            int id_article= res.getInt(1);
            String designation= res.getString(2);
            Double prix_Unitaire_HT=res.getDouble(3);
            Double ttc= res.getDouble(4);
            String  categorie= res.getString(5);
            a =new Article(id_article,designation,prix_Unitaire_HT, ttc,categorie);
            lesarticles.add(a);
    
            }
            st.close();
            } catch (SQLException e)
            {
            System.out.println("Exception dans la requete de récupération des Articles");
            }
            return lesarticles;
            }   
        


    //**********************************************************************    
        public Article getArticle(int id_article) {
            Article art = null;
            if (id_article == 0)
                return art;
            Connection cnx = SConnection.getInstance();
    
            try {
                PreparedStatement st = cnx.prepareStatement("select * from article where id_article= ?");
                st.setInt(1, id_article);
                ResultSet res = st.executeQuery();
                if (res.next())
    
                {
                    
                     art = new Article(res.getInt(1), res.getString(2),res.getDouble(3),res.getDouble(4),res.getString(5));
                }
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    
            return art;
        }
    
    // ************************************************************
        public void remove_Article(int id_article) {
            Connection cnx = SConnection.getInstance();
            int n = 0;
            try {
            PreparedStatement st = cnx.prepareStatement("delete  from article where id_article= ?");
            st.setInt(1, id_article);
            n = st.executeUpdate();
            st.close();
            System.out.println("la suppresion du article est effectuée avec succées ");
            } catch (SQLException e) {
            System.out.println("Echec du supression");
            }}
        private static   List<Article> articles= new ArrayList<Article>();
		
		public static void main(String[] args) {
			ArticleDAO cdao= new ArticleDAO();
            Article c1= new Article(123,"clavier",12,15,"peripher entree");
            Article c2= new Article(456,"sourie",18,51,"periphe sortie");
            Article c3= new Article(789,"imprimante",85,13,"periphe sortie");
                articles.add(c1);
                articles.add(c2);
                //System.out.println(articles);
                cdao.save(c1);
                System.out.println("*****Sauvegarde/MAJ du article c1");
                cdao.save(c2);
                System.out.println("*****Sauvegarde/MAJ du article c2");
                articles.add(c3);
                cdao.save(c3);
                 System.out.println("*****Sauvegarde/MAJ du article c3");
                System.out.println(cdao.getArticles());
           //System.out.println("L'article a pour id :"+ cdao.getArticle(123).getId_article()+ ", et designation : "+cdao.getArticle(123).getDesignation()+ ", et prixHT : "+cdao.getArticle(123).getPrix_Unitaire_HT()+ ", et de prix ttc  : "+cdao.getArticle(123).getTtc()+ ", et de categorie : "+cdao.getArticle(123).getCategorie());
            cdao.remove_Article(789);
             System.out.println("la requette supprimer est executer");
}}
