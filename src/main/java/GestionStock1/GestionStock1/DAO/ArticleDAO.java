package GestionStock1.GestionStock1.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import GestionStock1.GestionStock1.Metiers.Article;
import GestionStock1.GestionStock1.Metiers.Client;

public class ArticleDAO {
	
	
	public void AddArticle(Article c) {
		if (c == null)
		return;
		Connection cnx = SConnection.getInstance();
		
String rq=
"insert into article (id_article, designation,prix_Unitaire_HT,ttc,categorie) values (?,?,?,?,?)";
try {	

	PreparedStatement st = cnx.prepareStatement(rq);
	st=cnx.prepareStatement(rq);           
    st.setString(1,c.getId_article());
    st.setString(2, c.getDesignation() );   
    st.setDouble(3, c.getPrix_Unitaire_HT() );  
    st.setDouble(4, c.getTtc() );   
    st.setString(5, c.getCategorie() ); 
System.out.println("mmmm");
		int n = st.executeUpdate();
		if(n>0){
			System.out.println("ajout effectuée avec succéss");

		}
		} catch (SQLException e) {
			System.out.println(e);
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
    
            String  id_article= res.getString(1);
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
            System.out.println("Exception dans la requéte de récupération des Articles");
            }
            return lesarticles;
            }   
        


    //**********************************************************************    
        
        public Object[][] consulter_stock() {
            Object[][] donnes = new Object[100][4];

            try {
                Connection cnx = SConnection.getInstance();
                String r = "select * from article";
                /*initialisation de lobjet stat de type prepareStatement*/
               Statement s = cnx.createStatement();
               ResultSet rs = s.executeQuery(r);
                int i = 0;
                while (rs.next()) {
                	donnes[i][0] = rs.getString("id_article");
                    donnes[i][1] = rs.getString("designation");
                    donnes[i][2] = rs.getDouble("prix_Unitaire_HT");
                    donnes[i][3] = rs.getDouble("ttc");
                    donnes[i][4] = rs.getString("categorie");

                   System.out.println("fffff");
                    i++;
                }
            } catch (Exception e) {
            	//System.out.println("erreur");
            }
            return donnes;
        }  
        //*********************************************************//
        public Article FindById(String id_article) {
			Article  c =null;

		
			Connection cnx=SConnection.getInstance();
		try {

		String req1 = "select * from article where id_article=?";
		PreparedStatement st =cnx.prepareStatement(req1);

				st.setString(1,id_article);
				ResultSet res = st.executeQuery();
				
				while (res.next())
				{
					
				 c =new Article(res.getString(1),res.getString(2),res.getDouble(3), res.getDouble(4),
		res.getString(5));
			
				}
				st.close();
			}catch (SQLException e) {
				System.out.println("id article trouvé ");
				
	}
								
		return c;
        }
    
    // ************************************************************
        public void remove_Article(String id_article) {
            Connection cnx = SConnection.getInstance();
            int n = 0;
            try {
            PreparedStatement st = cnx.prepareStatement("delete  from article where id_article= ?");
            st.setString(1, id_article);
            n = st.executeUpdate();
            st.close();
            System.out.println("la suppresion du article est effectuée avec succées ");
            } catch (SQLException e) {
            System.out.println("Echec du supression");
            }}
        
        private static   List<Article> articles= new ArrayList<Article>();
		
		public static void main(String[] args) {
			ArticleDAO cdao= new ArticleDAO();
			
            Article c1= new Article("ART-111","clavier",12,15,"péripherique d'entree");
            Article c2= new Article("ART-222","souris",18,51,"péripherique sortie");
            Article c3= new Article("ART-333","imprimante",85,13,"péripherique sortie");
            Article c4= new Article("ART-444","imprimante",85,13,"péripherique sortie");

                articles.add(c1);
                articles.add(c2);
                articles.add(c3);

                //System.out.println(articles);
                cdao.AddArticle(c1);
                System.out.println("*****Ajout  du article c1");
                cdao.AddArticle(c2);
                System.out.println("*****Ajout du article c2");
                cdao.AddArticle(c3);
                 System.out.println("*****Ajout du article c3");
                System.out.println(cdao.getArticles()); 
                //cdao.FindById("ART-222");

  cdao.remove_Article(c1.getId_article());
  cdao.AddArticle(c1);
cdao.AddArticle(c4);
  cdao.consulter_stock();
}}
