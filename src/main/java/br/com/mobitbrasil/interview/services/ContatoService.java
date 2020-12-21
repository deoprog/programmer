package br.com.mobitbrasil.interview.services;

import javax.websocket.server.PathParam;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static com.sun.mail.iap.Response.OK;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/contatos")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class ContatoService {

	@GET
    public Response index() {

		return Response.status(OK)
                .type(APPLICATION_JSON)
                .entity("{value: \"Get\"}")
                .build();
    }
	
	@POST
    public Response add() {

        return Response
                .status(OK)
                .type(APPLICATION_JSON)
                .entity("{value: \"Contatos\"}")
                .build();
    }
	
	@PUT
    public Response update() {

        return Response.status(OK)
                .type(APPLICATION_JSON)
                .entity("{value: \"Update\"}").build();
    }
	
	@DELETE
    @Path("/{id}")
    public Response remove(@PathParam(value = "id") Long id) {

        return Response.status(OK)
                .type(APPLICATION_JSON)
                .entity("{value: \"Remove\"}").build();
    }

	
	@GET
    @Path("/{id}/telefones")
    public Response findEnderecoById(@PathParam(value = "id") Long id) {

        return Response.status(OK)
                .type(APPLICATION_JSON)
                .entity("{value: \"Telefones\"}").build();
    }
	
}
