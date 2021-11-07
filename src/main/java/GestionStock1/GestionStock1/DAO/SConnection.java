package GestionStock1.GestionStock1.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SConnection {
	//Initialisation des attributs
	private static String url = "jdbc:mysql://localhost:3306/bdgestionstock";
	private static String utilisateur= "root";
	private static String motPasse="";
	private static Connection cnx;

	//=============== getInstance()  ============================
	public static Connection getInstance()
	{  
	try 
	 	{
			if(cnx==null || cnx.isClosed()) {
			 //Vérifier le chargement en mémoire du pilote JDBC
			 Class.forName("com.mysql.jdbc.Driver");
			 
			 //Etablir la connexion
			 cnx=DriverManager.getConnection(url,utilisateur,motPasse);
			 System.out.println("Connexion à la base de données ");
			}
			}
			catch (ClassNotFoundException e) {
			System.out.println("Classe Driver introuvable");
			}
			catch (SQLException e) {
			System.out.println("L'établissement de la connexion a échoué.");
			}
	return cnx;
	}
	/*public static Connection getInstance() {
	    
	    Connection conn = null;
	    
	    try {
	        
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        
	        // com.mysql.jdbc.Driver
	        
	        conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bdgestionstock", "root", "");
	        
	    } catch(Exception ex) {     
	        System.out.println(ex.getMessage());
	    }
	    return conn;
	}*/
	//-------------Fermer la connexion-----------------------
	public static void close()
	{
	try{
	if(cnx!=null && !cnx.isClosed()) {
	cnx.close();}
	  }
	catch(SQLException e){
	System.out.print("Erreur lors de la fermeture de la connexion ");
	}
	}
}
