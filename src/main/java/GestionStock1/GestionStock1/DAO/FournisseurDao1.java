package GestionStock1.GestionStock1.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import GestionStock1.GestionStock1.Metiers.Facture;
import GestionStock1.GestionStock1.Metiers.Fournisseur;

public class FournisseurDao1{
Connection cnx= SConnection.getInstance();
//----------------------------------------FindAll----------------------------------------------------------------//
public ArrayList<Fournisseur> FindAll() {
ArrayList<Fournisseur> lesFournisseurs= new ArrayList<Fournisseur>();
PreparedStatement st;
Fournisseur f = null;
try {
String rq="select * from fournisseur";
st=cnx.prepareStatement(rq);
ResultSet res = st.executeQuery();
while (res.next()) {
f =new Fournisseur(res.getInt(1),res.getString(2),res.getString(3));
lesFournisseurs.add(f);
}
st.close();

} catch (SQLException e) {
e.printStackTrace();
}

return lesFournisseurs;
}
//--------------------------------------FindNom-------------------------------------------------------//
public Fournisseur FindByNom(String nom) {
Fournisseur  f =null;


Connection cnx=SConnection.getInstance();
try {

String req1 = "select * from fournisseur where nom=?";
PreparedStatement st =cnx.prepareStatement(req1);

st.setString(1,nom);
ResultSet res = st.executeQuery();

while (res.next())
{
f =new Fournisseur(res.getInt(1),res.getString(2),res.getString(3));

}
st.close();
}catch (SQLException e) {
System.out.println("nom de fournisseur  trouvé ");

}

return f;

}

//--------------------------Ajout fournisseur-----------------------------------------------------//
public void AddFournisseur(Fournisseur f) {
if (f == null)
return;
Connection cnx = SConnection.getInstance();

String rq=
"insert into fournisseur (id_fournisseur,nom, adresse)  values ( ?, ?,?)";
try {

PreparedStatement st = cnx.prepareStatement(rq);
st.setInt(1, f.getId_fournisseur());
st.setString(2, f.getNom());
st.setString(3, f.getAdresse());
int n = st.executeUpdate();
if(n>0){
System.out.println("ajout du fournisseur  effectuée avec succéss");

}
} catch (SQLException e) {
System.out.println(e);
}

}


//*********************************** Supression************************************************************************//
public void remove_Fournisseur(int id_fournisseur) {

Connection cnx = SConnection.getInstance();
int n = 0;
try {
PreparedStatement st = cnx.prepareStatement("delete  from fournisseur where id_fournisseur= ?");
st.setInt(1, id_fournisseur);
n = st.executeUpdate();
st.close();
System.out.println("la suppresion du fournisseur  est effectuée avec succées ");
} catch (SQLException e) {
System.out.println("Echec du supression du fournisseur ");
}

}


private static   List<Fournisseur> lesFournisseurs = new ArrayList<Fournisseur>();

public static void main(String[] args) {
Fournisseur f1=new Fournisseur(1111, "ahmed", "sfax");
Fournisseur f2=new Fournisseur(2222, "isam", "sousse");
Fournisseur f3=new Fournisseur(4444, "mohamed", "tunis ");

lesFournisseurs.add(f1);
lesFournisseurs.add(f2);
lesFournisseurs.add(f3);
System.out.println(lesFournisseurs);
FournisseurDao1 dao=new FournisseurDao1();

dao.AddFournisseur(f1);
dao.AddFournisseur(f2);
dao.AddFournisseur(f3);
   dao.remove_Fournisseur(2222);

}





}
