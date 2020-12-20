package br.com.mobitbrasil.interview.services;

import br.com.mobitbrasil.interview.beans.AgendaBean;
import lombok.val;

import javax.ejb.EJB;
import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.APPLICATION_XML;

@Path("/agenda")
@Produces({APPLICATION_XML, APPLICATION_JSON})
public class AgendaService {

    @EJB
    AgendaBean agendaBean;

    @GET
    @Produces(APPLICATION_JSON)
    public Response status() {
        return Response.ok("{descricao: \"teste\"}").build();
    }

    @GET
    @Path("{id}")
    @Produces(APPLICATION_JSON)
    public Response findById(@PathParam("id") Long id) {

        val agenda = agendaBean.findById(id);

        return Response.ok(agenda.toString()).build();
    }
}
