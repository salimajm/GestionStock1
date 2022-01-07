package GestionStock1.GestionStock1.Controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import org.glassfish.jersey.process.internal.RequestScoped;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import GestionStock1.GestionStock1.Metiers.Article;
import GestionStock1.GestionStock1.Controller.*;
import GestionStock1.GestionStock1.DAO.*;
import GestionStock1.GestionStock1.Metiers.Client;
import GestionStock1.GestionStock1.Metiers.Facture;
import GestionStock1.GestionStock1.Metiers.Fournisseur;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.*;

import jakarta.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
    
    ClientDAO bd =new ClientDAO();
    ArticleDAO bdart =new ArticleDAO();
    FactureDAO fbd=new FactureDAO();
    FournisseurDao1 dao=new FournisseurDao1();
    CommandeClientDao dao1=new CommandeClientDao();
    
    
/**************************************CLIENTS*************************/
 // http://localhost:8081/GestionStock1/webapi/myresource/clients
     @GET
     @Path("clients")
     @Produces("application/json")

     public Collection<Client> getClients(){ 

     System.out.println("getClients"); 

    return bd.FindAll(); 
     
     } 
/*{
        "adresse": "Tunisie",
        "cin": 11141103,
        "commandeClients": [],
        "dateNaissance": "1999-08-20",
        "email": "personne@gmail.com",
        "id_Client": "IA333",
        "nom_Client": "Amira",
        "prenom_Client": "X",
        "sexe": "femme",
        "telephone": 22677545,
        "ville": "Tunisie"
    }*/
   @POST
    @Path( "createclient")
    public void createclient(@RequestBody Client cl){ 
        bd.AddClient(cl);;
}
  //http://localhost:8085/GestionStock1/webapi/myresource/remove?id_client=555
    @DELETE
    @Path("remove")
  // @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public void remove_client(@QueryParam("id_Client") String id_Client) 
    { 
        bd.remove_client(id_Client);
        System.out.println("client est supprimé avec succés ");
        	 }
  //http://localhost:8085/GestionStock1/webapi/myresource/modifyclient/555?telephone=65645456    
    @PUT
    @Path("modifyclient")
    public void modifyclient(@QueryParam("id_client") String id_client ) 
    { 
    	Client c = new Client(id_client);

        bd.save(c);
    }
 // http://localhost:8081/demo/findclientById/FindById?id_client=555
    @GET
    @Path("findclientById")
    @Produces(MediaType.APPLICATION_JSON)
    public Client FindById(@QueryParam("id_Client") String id_Client ) { 
    	System.out.println(id_Client);
    	return bd.FindById(id_Client);
    }
 // http://localhost:8081/GestionStock1/webapi/myresource/findclientByNom?nom_client=Mezghanni
    @GET
    @Path("findclientByNom")
    @Produces(MediaType.APPLICATION_JSON)
    public Client FindByNom(@QueryParam("nom_client") 
    					String nom_Client ) { 
    	System.out.println(nom_Client);

    	 return bd.FindByNom(nom_Client);
    }
    /*****************************ARTICLES*********************************/
    //http://localhost:8081/GestionStock1/webapi/myresource/articles
    @GET
    @Path("articles")
    @Produces(MediaType.APPLICATION_JSON)

    public Collection<Article> getArticles() { 

    	System.out.println("getArticles"); 

        return bdart.getArticles() ;
    
    }
    /*{
        "categorie": "péripherique d'entree",
        "designation": "MSI PC",
        "id_article": "ART-333",
        "prix_Unitaire_HT": 3000.0,
        "ttc": 15.0
    }*/
    @POST
    @Path( "create")
    public void createArticle(@RequestBody Article a){ 
        bdart.AddArticle(a);
}
 // http://localhost:8085/GestionStock1/webapi/myresource/findById?id_client=555
    @GET
    @Path("findById")
    @Produces(MediaType.APPLICATION_JSON)
    public Article FindArticleById(@QueryParam("id_Article") String id_Article ) { 
    	System.out.println(id_Article);
    	return  bdart.FindById(id_Article);
    }
  //http://localhost:8085/GestionStock1/webapi/myresource/modifyart/ART-333?prix_Unitaire_HT=3500.0    
    @PUT
    @Path("modifyart")
    public void modifyarticle(@QueryParam("id_article") String id_article ) 
    { 
    	Article c = new Article(id_article);

        bdart.AddArticle(c);
    }
  //http://localhost:8085/GestionStock1/webapi/myresource/remove?id_client=555
    @DELETE
    @Path("remove")
  // @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public void remove_article(@QueryParam("id_Article") String id_Article) 
    { 
        bd.remove_client(id_Article);
        System.out.println("client est supprimé avec succés ");
        	 }
    /***************************************FACTURE*************************************/
    @GET
    @Path("factures")
    @Produces(MediaType.APPLICATION_JSON)

    public Collection<Facture> getFactures() { 

    	System.out.println("getFactures"); 

        return fbd.getFactures() ;
    
    }
    @POST
    @Path( "create")
    public void createFacture(@RequestBody Facture f){ 
        fbd.AddFacture(f);
}
 
    @PUT
    @Path("modifyart")
    public void modify(@QueryParam("id_Facture") int id_Facture ) 
    { 
    	Facture c = new Facture(id_Facture);

        fbd.AddFacture(c);
    }
    @DELETE
    @Path("remove")
    @Produces({MediaType.APPLICATION_JSON})
    public void remove(@QueryParam("id_Facture") int id_Facture) 
    { 
        fbd.remove_Facture(id_Facture);;
        System.out.println("facture est supprimé avec succés ");
        	 }
    /***********************************Fournisseur*******************************/
   
    @POST
    @Path( "create")
    public void createFournisseur(@RequestBody Fournisseur f){ 
        dao.AddFournisseur(f);
}
 
    @PUT
    @Path("modiffour")
    public void modifyFournisseur(@QueryParam("id_Fournisseur") int id_Fournisseur ) 
    { 
    	Fournisseur c = new Fournisseur(id_Fournisseur);

       dao.AddFournisseur(c);
    }
    @DELETE
    @Path("removefour")
    @Produces({MediaType.APPLICATION_JSON})
    public void removeFournisseur(@QueryParam("id_Fournisseur") int id_Fournisseur) 
    { 
        fbd.remove_Facture(id_Fournisseur);;
        System.out.println("fournisseur est supprimé avec succés ");
        	 }
    }
