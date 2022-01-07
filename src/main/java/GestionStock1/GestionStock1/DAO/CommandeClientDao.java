package GestionStock1.GestionStock1.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import GestionStock1.GestionStock1.Metiers.Client;
import GestionStock1.GestionStock1.Metiers.CommandeClient;

public class CommandeClientDao {
Connection cnx= SConnection.getInstance();
//----------------------------------------FindAll----------------------------------------------------------------//
public ArrayList<CommandeClient> FindAll() {
ArrayList<CommandeClient> lescommandes= new ArrayList<CommandeClient>();
PreparedStatement st;
CommandeClient cc = null;
try {
String rq="select * from commandeClient";
st=cnx.prepareStatement(rq);
ResultSet res = st.executeQuery();
while (res.next()) {
cc =new CommandeClient(res.getInt(1),res.getString(2),res.getString(3), res.getInt(4));
lescommandes.add(cc);
}
st.close();

} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}

return lescommandes;
}

//--------------------------------------FindId-------------------------------------------------------//
public CommandeClient FindById(int id_commande) {
CommandeClient  cc =null;


Connection cnx=SConnection.getInstance();
try {

String req1 = "select * from commandeClient where id_commande=?";
PreparedStatement st =cnx.prepareStatement(req1);

st.setInt(1,id_commande);
ResultSet res = st.executeQuery();

while (res.next())
{
cc =new CommandeClient(res.getInt(1),res.getString(2),res.getString(3), res.getInt(4));

}
st.close();
}catch (SQLException e) {
System.out.println("id commande  trouvé ");

}

return cc;

}


//--------------------------Ajout commande-----------------------------------------------------//
public void AddCommandeClient(CommandeClient cc) {
if (cc == null)
return;
Connection cnx = SConnection.getInstance();

String rq=
"insert into commandeClient (id_commande,nom_article, categorie,quantite)  values (?, ?, ?,?)";
try {

PreparedStatement st = cnx.prepareStatement(rq);
st.setInt(1, cc.getId_Commande());
st.setString(2, cc.getNom_Article());
st.setString(3, cc.get_Categorie());
st.setInt(4, cc.getQuantite());
int n = st.executeUpdate();
if(n>0){
System.out.println("ajout du commande client  effectuée avec succéss");

}
} catch (SQLException e) {
System.out.println(e);
}

}


//*********************************** Supression************************************************************************//
public void remove_commande(int id_commande) {

Connection cnx = SConnection.getInstance();
int n = 0;
try {
PreparedStatement st = cnx.prepareStatement("delete  from commandeClient where id_commande= ?");
st.setInt(1, id_commande);
n = st.executeUpdate();
st.close();
System.out.println("la suppresion du commande client  est effectuée avec succées ");
} catch (SQLException e) {
System.out.println("Echec du supression du commande ");
}

}


private static   List<CommandeClient> lescommandes = new ArrayList<CommandeClient>();

public static void main(String[] args) {
CommandeClient cc1=new CommandeClient(1111, "souris", "peripherique d'entrées", 88);
CommandeClient cc2=new CommandeClient(2222, "clavier", "peripherique d'entrées", 42);
CommandeClient cc3=new CommandeClient(4444, "souris", "peripherique de sortis ", 50);

lescommandes.add(cc1);
lescommandes.add(cc2);
lescommandes.add(cc3);
System.out.println(lescommandes);
CommandeClientDao dao=new CommandeClientDao();

dao.AddCommandeClient(cc1);
dao.AddCommandeClient(cc2);
dao.AddCommandeClient(cc3);
      dao.remove_commande(2222);

}}
