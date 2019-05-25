/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SourceCode;

import static java.nio.file.Files.delete;
import javax.annotation.PostConstruct;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author CAR
 */
@Path("/colors")
public class ItemsResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ItemsResource
     */
    public ItemsResource() {
    }

    /**
     * Retrieves representation of an instance of SourceCode.ItemsResource
     * @return an instance of java.lang.String
     */
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String initialize() {
        ColorSet.getInstance().initialize();
        return ColorSet.getInstance().getColors();
    }
    
    /**
     *
     * @param id
     * @return
     */
    @Path("/{id}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getColor(@PathParam("id") int id){
        if(ColorSet.getInstance().doesExist(id) == false){
           return Response.status(404).entity("Cannot find color").build();
        }
        return Response.status(200).entity(ColorSet.getInstance().getColor(id)).build();
    }

    /**
     * POST method for creating an instance of ItemResource
     * @param name
     * @param hex
     
     * @return an HTTP response with content of the created resource
     */
    
   
    @POST
    @Path("/add")
    public Response addColor(@FormParam("name") String name, 
            @FormParam("hex") String hex
    ) {
        ColorSet.getInstance().addColor(name, hex);
        return Response.status(200).entity(name + " " + hex + " has been added").build();
    }
    
    /**
     *
     * @param id
     * 
     * @return
     */
   @Path("/{id}")
    @PUT
    @Produces(MediaType.TEXT_PLAIN)
     public Response updateItem(@PathParam("id") int id, @FormParam("name") String name, @FormParam("hex") String hex){
        if(ColorSet.getInstance().doesExist(id)){
            return Response.status(200).entity("Something already exists with this id").build();
        }
            ColorSet.getInstance().addColor(name,hex);
            return Response.status(200).entity("Color has been updated").build();
     }
    
   @Path("/{id}")
    @DELETE
   public Response deleteColor(@PathParam("id") int id){
       if(ColorSet.getInstance().doesExist(id) == false){
           return Response.status(404).entity("Cannot find color").build();
        }
       ColorSet.getInstance().deleteColor(id);
       return Response.status(200).entity("Color has been deleted").build();
    }

    /**
     * Sub-resource locator method for {id}
     */
    @Path("{id}")
    public ItemResource getItemResource(@PathParam("id") String id) {
        return ItemResource.getInstance(id);
    }
}
