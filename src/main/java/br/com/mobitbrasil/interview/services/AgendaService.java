package br.com.mobitbrasil.interview.services;

import br.com.mobitbrasil.interview.beans.AgendaBean;
import br.com.mobitbrasil.interview.domains.AgendaDTO;
import br.com.mobitbrasil.interview.model.Agenda;
import lombok.val;

import javax.ejb.EJB;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/agenda")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class AgendaService {

    @EJB
    private AgendaBean agendaBean;

    @GET
    public Response index() {
        return Response.ok("{descricao: \"teste\"}").build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam(value = "id") Long id) {

        val agenda = agendaBean.findById(id);

        return Response.ok(agenda).build();
    }

    @POST
    public Response save(@Valid AgendaDTO agenda) {
        return Response.ok(agenda).build();
    }
}
