package rest;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import entities.Pet;
import entities.PetFacade;
import entities.messages.JSONMessage;
import entities.messages.PetMessage;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONObject;

@Path("pets")
public class PetResource {

    Gson gson = new Gson();
    PetFacade petFacade = new PetFacade();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PetResource
     */
    public PetResource() {
    }

    /**
     * Retrieves representation of an instance of rest.PetResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getPets() {
        //JsonObject messages = new JsonObject();

        ArrayList<JSONMessage> messages = new ArrayList<>();
        for (Pet pet : petFacade.getAllPets()) {
            messages.add(new PetMessage(pet));
        }

        return gson.toJson(messages);
    }

    @Path("/count")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCount() {
        //Laver et json objekt
        JsonObject jsonObj = new JsonObject();

        jsonObj.add("PetCount", new JsonPrimitive(PetFacade.countAllPets()));

        return Response.ok(new Gson().toJson(jsonObj)).build();//Eller bare gson.
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getSpecificJson(@PathParam("id") Integer id) {

        Pet p = petFacade.getAllPets().get(id);
        return gson.toJson(p);

    }

    /**
     * PUT method for updating or creating an instance of PetResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }

}
