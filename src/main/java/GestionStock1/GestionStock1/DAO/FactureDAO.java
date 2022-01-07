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



public class FactureDAO {
public void AddFacture(Facture f) {
if (f == null)
return;
Connection cnx = SConnection.getInstance();
String rq=
"insert into facture(id, montant,date) values(?,?,?);";
try {

PreparedStatement st = cnx.prepareStatement(rq);
st.setInt(1,f.getId());
     st.setDouble(2,f.getMontant()  );
     st.setObject(3, f.getDate()  );
int n = st.executeUpdate();
if(n>0){
System.out.println("ajout  de facture  effectuée avec succéss");

}
} catch (SQLException e) {
System.out.println(e);
}

}

//*****************************************************************
    public Collection<Facture> getFactures() {
        String rq="select * from facture";
        Collection<Facture> lesFactures= new ArrayList<Facture>();
        Connection cnx= SConnection.getInstance();
        PreparedStatement st=null;
        Facture f = null;
        try {
        st=cnx.prepareStatement(rq);
        ResultSet res = st.executeQuery();
        while (res.next()) {
         int id= res.getInt(1);
         double montant= res.getDouble(2);
        Date date= (Date) res.getObject(3);
       f =new Facture(date,montant,id);
        lesFactures.add(f);

        }
        st.close();
        } catch (SQLException e)
        {
        System.out.println("Exception dans la requete de récupération des factures");
        }
        return lesFactures;
        }  

   
  //**********************************************************************    
    public Facture getFacture(int id) {
    Facture f = null;
        if (id == 0)
            return f;
        Connection cnx = SConnection.getInstance();

        try {
            PreparedStatement st = cnx.prepareStatement("select * from facture where id= ?");
            st.setInt(1, id);
            ResultSet res = st.executeQuery();
            if (res.next())

            {
               
                 f = new Facture(res.getDate(1),res.getDouble(2) ,res.getInt(3));
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return f;
    }
   
 // ************************************************************
    public void remove_Facture(int id) {
        Connection cnx = SConnection.getInstance();
        int n = 0;
        try {
        PreparedStatement st = cnx.prepareStatement("delete  from facture where id= ?");
        st.setInt(1, id);
        n = st.executeUpdate();
        st.close();
        System.out.println("la suppresion du facture est effectuée avec succées ");
        } catch (SQLException e) {
        System.out.println("Echec du supression");
        }
        }
   
    /**************************************save************************************************/
  public void save(Facture f) {
  int n=0;
  Connection cnx= SConnection.getInstance();
  PreparedStatement st = null;
  try {
  st=cnx.prepareStatement("update facture set id=? montant=?,date=?");
  st.setInt(1, f.getId());
  st.setDouble(2, f.getMontant());
  st.setObject(3, f.getDate());

  n= st.executeUpdate();
  st.close();
  if(n==1) {
  System.out.println("Mise à jour du facture avec succès ");
  }
  } catch (SQLException e) {
  System.out.println("Mise à jour du facture a échoué ");
  }
  if(n==0)
  {try
  {
      this.AddFacture(f);
  System.out.println("Ajout du facture avec succès ");
  st.close();
  } catch (SQLException e) {
  System.out.println("L'ajout du facture a échoué ");
  }
  }
  }
     
     
     
     
      public static void main(String[] args) {
              List<Facture> factures= new ArrayList<Facture>();
              FactureDAO facDao= new FactureDAO();
              Facture f1 = new Facture(new Date(2021-12-5),12.2,2);  
              Facture f2 = new Facture(new Date(2021-11-5),56.2,3);  
              factures.add(f1);
              factures.add(f2);
           
                  System.out.println(factures);
                  facDao.save(f1);
                 System.out.println("*****Sauvegarde/MAJ du facture f1");
                 facDao.save(f2);
                 System.out.println("*****Sauvegarde/MAJ du facturef2");
                 // System.out.println(facDao.getFactures());
                  facDao.remove_Facture(2);
              System.out.println("la requette supprimer est executer");
  }
 

}