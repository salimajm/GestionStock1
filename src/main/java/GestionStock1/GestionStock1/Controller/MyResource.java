package GestionStock1.GestionStock1.Controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import GestionStock1.GestionStock1.Metiers.Article;
import GestionStock1.GestionStock1.Controller.*;
import GestionStock1.GestionStock1.DAO.*;
import GestionStock1.GestionStock1.Metiers.Client;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
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

 // http://localhost:8081/GestionStockBd/clients
     @GET
     @Path("clients")
     @Produces("application/json")
     public Collection<Client> getClients(){ 

     System.out.println("getClients"); 

    return bd.FindAll(); 
     
     } 
     
     //&nom_client=jmal&prenom_client=salima&email=mlmlmlml&adresse=gremda&telephone=25490581&sexe=femme &cin=1556255&date=3900-08-16&ville=gremda
	//http://localhost:8085/demo/clients/createclient?id_client=555&nom_client=jmal &prenom_client=salima
    //email=salimajmal18@gmail.com &adresse=gremda& telephone=25490581&sexe=femme&cin=1556255&date=30/07/2000&ville=gremda
    @POST
    @Path("createclient")
    //@Consumes("application/JSON")
    public void createclient(
	    		@QueryParam("id_client") String id_client
	            ){ 
    System.out.println("hello");    
Client c = new Client(id_client);
        bd.AddClient(c);
}
  //http://localhost:8085/demo/clients/removeclient/555
    @DELETE
    @Path("removeclient/{id_client}")
    public void remove_client(@PathParam("id_client") String id_client) 
    { 
        bd.remove_client(getIt());
        	 }
  //http://localhost:8085/demo/clients/modifyclient/555?telephone=65645456    
   /* @PUT
    @Path("modifyclient")
    public void modifyclient(@QueryParam("id_client") String id_client,
            @QueryParam("nom_client") String nom_client,
            @QueryParam("prenom_client") String prenom_client,
            @QueryParam("email") String email, @QueryParam("adresse") 
String adresse, @QueryParam("telephone") int telephone  ,
@QueryParam("sexe") String sexe,
@QueryParam("cin") int cin,
@QueryParam("dateNaissance") LocalDate date , 
    @QueryParam("ville") String ville ) 
    { 
    	Client c = new Client(id_client,nom_client,prenom_client,email,adresse,telephone,sexe,cin,date,ville);

        bd.save(c);
    }*/
 // http://localhost:8081/demo/findclientById/FindById?id_client=555
    @GET
    @Path("findclientById")
    @Produces("application/JSON")
    public ArrayList<Client> FindById(@QueryParam("id_Client") 
    					String id_Client ) { 
    	 return bd.FindById(id_Client);
    }
 // http://localhost:8081/demo/clients/searchclient?id_client=555
    @GET
    @Path("findclientByNom")
    @Produces("application/JSON")
    public ArrayList<Client> FindByNom(@QueryParam("nom_client") 
    					String nom_Client ) { 
    	 return bd.FindByNom(nom_Client);
    }
    @GET
    @Path("articles")
    @Produces("application/json")
    public Collection<Article> getArticles() { 

    	System.out.println("getArticles"); 

        return bdart.getArticles() ;
    
    }
    }
