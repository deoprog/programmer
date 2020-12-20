package br.com.mobitbrasil.interview.services;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.APPLICATION_XML;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/api")
@Produces({APPLICATION_XML, APPLICATION_JSON})
public class ContatoService {

	//recupera uma lsita com os 10 primeiros contatos ordenado pelo nome
	@GET
    @Path("/contatos")
    @Produces(APPLICATION_JSON)
    public Response list() {

		return Response
                .status(Response.Status.ACCEPTED)
                .entity("Get").build();
    }
	
	//Cria um novo Contato a partir de um JSON enviado no body
	@POST
    @Path("/contatos")
    @Produces(APPLICATION_JSON)
	@Consumes(APPLICATION_JSON)
    public Response add() {

        return Response
                .status(Response.Status.ACCEPTED)
                .entity("Contatos").build();
    }
	
	//Atualiza um Contato a partir de um JSON enviado no body com o atributo Código existente;
	@PUT
    @Path("/contatos")
    @Produces(APPLICATION_JSON)
	@Consumes(APPLICATION_JSON)
    public Response update() {

        return Response
                .status(Response.Status.ACCEPTED)
                .entity("Alterado").build();
    }
	
	//Remove um contato a partir do código informado;
	@DELETE
    @Path("/contatos/{id}")
    @Produces(APPLICATION_JSON)
    public Response remove(@PathParam("id") Long id) {

        return Response.ok().build();
    }
	
	//Retorna um JSON do contato referente ao código informado.
	@GET
    @Path("/contatos/{id}")
    @Produces(APPLICATION_JSON)
    public Response findById(@PathParam("id") Long id) {

        return Response.ok().build();
    }
	
	//Retorna um JSON dos endereços do contato referente ao código informado.
	@GET
    @Path("/contatos/{id}/telefones")
    @Produces(APPLICATION_JSON)
    public Response findEnderecoById(@PathParam("id") Long id) {

        return Response.ok().build();
    }
	
}
