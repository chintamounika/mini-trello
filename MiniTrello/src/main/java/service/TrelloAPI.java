package service;

import com.google.gson.Gson;
import model.Card;
import model.CheckListEntry;

import controller.CardDao;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by chinta on 24/6/16.
 */

@Path("/trello-api")
public class TrelloAPI {
    @GET
    @Path("/listCards")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCardsList(){
        return Response.ok().entity(CardDao.getAllCards()).build();
    }

    @POST
    @Path("/saveCard")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveCard( String str){
        Gson gson = new Gson();
        Card card = gson.fromJson(str, Card.class);
        CardDao.saveCard(card);
        return Response.ok().build();
    }



    @GET
    @Path("/getEmptyItem")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmptyItem() {
        CheckListEntry item = CardDao.getEmptyItem();
        return Response.ok().entity(item).build();
    }


    @GET
    @Path("/getEmptyCard")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmptyCard() {
        Card card = CardDao.getEmptyCard();
        System.out.println("");
        return Response.ok().entity(card).build();
    }

    @DELETE
    @Path("/removeCard/{id}")
    public Response deleteCard(@PathParam("id") String id) {
        CardDao.removeCard(id);
        return Response.status(202).entity("Card deleted successfully !!").build();
    }


}
