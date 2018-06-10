/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import entities.Person;
import entities.PersonFacade;
import java.io.IOException;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Bo
 */
@Path("persons")
public class PersonResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Person
     */
    public PersonResource() {
    }

    /**
     * Retrieves representation of an instance of rest.PersonResource
     * @return an instance of java.lang.String
     * @throws java.io.IOException
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersons() throws IOException {
        
        List<Person> personList = PersonFacade.getAllPersons();
        
        return Response.ok(new Gson().toJson(personList)).build();
    }
    
    @GET
    @Path("/lesspersons/{number}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getImageById(@PathParam("number") int number) throws IOException {
        List<Person> personList = PersonFacade.getNumberOfPersons(number);
        
        return Response.ok(new Gson().toJson(personList)).build();
}

    /**
     * PUT method for updating or creating an instance of PersonResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}