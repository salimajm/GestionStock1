package GestionStock1.GestionStock1.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import GestionStock1.GestionStock1.Metiers.*;
import GestionStock1.GestionStock1.Controller.*;

public class ClientDAO {
	Connection cnx= SConnection.getInstance();
	//----------------------------------------FindAll----------------------------------------------------------------//
			public ArrayList<Client> FindAll() {
				ArrayList<Client> lesclients= new ArrayList<Client>();
				PreparedStatement st;
				Client c = null; 
				try {
				String rq="select * from client";
				st=cnx.prepareStatement(rq);
				ResultSet res = st.executeQuery();
				while (res.next()) {
						c =new Client(res.getString(1),res.getString(2),res.getString(3), res.getString(4),
						res.getString(5),res.getInt(6),res.getString(7),res.getInt(8),res.getObject(9,LocalDate.class),res.getString(10));
						lesclients.add(c);
						}
				st.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
				
					return lesclients;
					}
			//--------------------------------------FindId-------------------------------------------------------//
			public ArrayList<Client> FindById(String id_client) {
					Connection cnx;
			ArrayList<Client> resultat = new ArrayList<Client>();
			cnx=SConnection.getInstance();
			try {

			String req1 = "select * from client where id_Client=?";
			PreparedStatement st =cnx.prepareStatement(req1);

					st.setString(1,id_client);
					ResultSet res = st.executeQuery();
					String id_Client=null;
					String nom_Client =null;
					String prenom_Client = null;
					String  email = null;
					String  adresse = null;
					int telephone = 0;
					String  sexe = null;
					int cin = 0;
					Date dateNaissance=null;
					String  ville= null;
				
					Client  cl =null;
					while (res.next())
									{
						
					 cl =new Client(res.getString(1),res.getString(2),res.getString(3), res.getString(4),
								res.getString(5),res.getInt(6),res.getString(7),res.getInt(8),res.getObject(9,LocalDate.class),res.getString(10));
				
									}
					st.close();
									}
									catch (SQLException e) {
					System.out.println("id client  trouvé ");	
									}
									
									return resultat;
									}
			//----------------------------------------FindNom---------------------------------------------//
			public ArrayList<Client> FindByNom(String nom) 
					{
								Connection cnx;
			ArrayList<Client> resultat = new ArrayList<Client>();
			cnx=SConnection.getInstance();
			try {
								//la requette parametrés
			String req1 = "select * from client where nom=?";
				PreparedStatement st =cnx.prepareStatement(req1);
								
				st.setString(1, nom);
								
				ResultSet res = st.executeQuery();
				String id_Client=null;
				String nom_Client =null;
				String prenom_Client = null;
				String  email = null;
				String  adresse = null;
				int telephone = 0;
				String  sexe = null;
				int cin = 0;
				LocalDate dateNaissance=null;
				String  ville= null;
			
				Client  cl =null;
								while (res.next())
								{
					id_Client=res.getString(1);
					nom_Client =res.getString(2);
					 prenom_Client = res.getString(3);
					email = res.getString(4);
					adresse = res.getString(5);
					telephone = res.getInt(6);
					sexe =res.getString(7);
					cin = res.getInt(8);
					dateNaissance=res.getObject(9,LocalDate.class);
				 ville= res.getString(10);
			cl = new Client(id_Client,nom_Client, prenom_Client,email,adresse,telephone,sexe,cin,dateNaissance,ville);
						resultat.add(cl);
			
								}
								st.close();

								}
								catch (SQLException e) {
								// TODO Auto-generated catch bloc
			System.out.println("Nom du client  trouvé ");	;
								}
								finally {
								SConnection.close();
								}
								return resultat;
								}
		//--------------------------Ajout Client-----------------------------------------------------//
			public void AddClient(Client cl) {
				if (cl == null)
				return;
				Connection cnx = SConnection.getInstance();
				
		String rq=
		"insert into client (id_Client,nom_Client, prenom_Client,email,adresse,telephone,sexe,cin,dateNaissance,ville)  values (?, ?, ?,?,?,?,?,?,?,?)";
		try {	

			PreparedStatement st = cnx.prepareStatement(rq);
				st.setString(1, cl.getId_Client());
				st.setString(2, cl.getNom_Client());
				st.setString(3, cl.getPrenom_Client());
				st.setString(4, cl.getEmail());
				st.setString(5, cl.getAdresse());
				st.setInt(6, cl.getTelephone());
				st.setString(7, cl.getSexe());
				st.setInt(8, cl.getCin());
		        st.setObject(9, cl.getDateNaissance());
				st.setString(10, cl.getVille());
		System.out.println("mmmm");
				int n = st.executeUpdate();
				if(n>0){
					System.out.println("ajout effectuée avec succéss");

				}
				} catch (SQLException e) {
					System.out.println(e);
	}
		
		}
	//*********************************** Supression************************************************************************//
		public void remove_client(String id_Client) {
							
							Connection cnx = SConnection.getInstance();
							int n = 0;
							try {
								PreparedStatement st = cnx.prepareStatement("delete  from client where id_Client= ?");
								st.setString(1, id_Client);
								n = st.executeUpdate();
								st.close();
								System.out.println("la suppresion du client est effectuée avec succées ");
							} catch (SQLException e) {
		System.out.println("Echec du supression");					
		}
							
						}
		
		
		
		
		/**************************************save************************************************/
		public void save(Client cl) {
			int n=0;
			Connection cnx= SConnection.getInstance();
			PreparedStatement st;
			try {
			st=cnx.prepareStatement("update client set id_Client=? nom_Client=? prenom_Client=? email=?"
					+ "adresse=? telephone =? sexe =? cin=? dateNaissance =? ville=? where id_article=?");
			st.setString(1, cl.getId_Client());
			st.setString(2, cl.getNom_Client());
			st.setString(3, cl.getPrenom_Client());
			st.setString(4, cl.getEmail());
			st.setString(5, cl.getAdresse());
			st.setInt(6, cl.getTelephone());
			st.setString(7, cl.getSexe());
			st.setInt(8, cl.getCin());
	        st.setObject(9, cl.getDateNaissance());
			st.setString(10, cl.getVille());
			n= st.executeUpdate();
			st.close();
			if(n==1) {
			System.out.println("Mise à jour du client avec succès ");
			}
			} catch (SQLException e) {
			System.out.println("Mise à jour du client a échoué ");
			}
			if(n==0)
			{try {
			String rq2="insert into article(id_Client,nom_Client, prenom_Client,email,adresse,telephone,sexe,cin,dateNaissance,ville) values (?, ?, ?,?,?,?,?,?,?,?)";
			st=cnx.prepareStatement(rq2);
			st.setString(1, cl.getId_Client());
			st.setString(2, cl.getNom_Client());
			st.setString(3, cl.getPrenom_Client());
			st.setString(4, cl.getEmail());
			st.setString(5, cl.getAdresse());
			st.setInt(6, cl.getTelephone());
			st.setString(7, cl.getSexe());
			st.setInt(8, cl.getCin());
	        st.setObject(9, cl.getDateNaissance());
			st.setString(10, cl.getVille());
			n= st.executeUpdate();
			System.out.println("Ajout du client avec succès ");
			st.close();
			} catch (SQLException e) {
			System.out.println("L'ajout du client a échoué ");
			}
			}
			}
			   private static   List<Client> clients = new ArrayList<Client>();
		
			public static void main(String[] args) {
		Client cl1=new Client("555", "Jmal", "salima", "selimajmal18@gmail.com", "gremda", 25490581, "femme",1556255,  LocalDate.of(2000, 07, 30), "sfax" );
		Client cl2=new Client("6665", "Mezghanni", "amal", "amalmezghani18@gmail.com", "gremda", 25490581, "femme",1556255, LocalDate.of(2000, 07, 16), "sfax");
		Client cl3=new Client("IA456", "Mez", "hhh", "m", "gremda", 222, "femme",656, LocalDate.of(2000, 07, 16), "sousse");
		Client cl4=new Client("II233", "Mez", "hhh", "m", "afrane", 2235, "femme",656, LocalDate.of(2000, 07, 16), "sousse");

		clients.add(cl1);
		  clients.add(cl2);
		  clients.add(cl3);
		  clients.add(cl4);

		System.out.println(clients);
		ClientDAO dao=new ClientDAO();
		
		dao.AddClient(cl1);
		dao.AddClient(cl2);
		dao.AddClient(cl3);
		dao.AddClient(cl4);
		dao.save(cl1);
		dao.save(cl2);
		dao.save(cl3);
		dao.save(cl4);

       dao.remove_client("555");
		dao.FindByNom("jmal");

		}
}
