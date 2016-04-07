/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Beans.Product;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author c0611751
 */
@Path("/product")
@RequestScoped
public class ProductREST {
    @PersistenceContext(unitName="build11inclassPU")
    EntityManager em;
    
    List<Product> productList;
    
    @GET
    public Response getAll(){
        JsonArrayBuilder json = Json.createArrayBuilder();
        Query q = em.createQuery("SELECT p FROM Product p");
        productList = q.getResultList();
        for (Product p : productList){
            json.add(p.toJSON());
        }
        return Response.ok(json.build().toString()).build();
    }
    
}
