package br.com.mobitbrasil.interview.services;

import br.com.mobitbrasil.interview.beans.AgendaBean;
import lombok.val;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static com.sun.mail.iap.Response.OK;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/agenda")
public class AgendaService {

    @EJB
    private AgendaBean agendaBean;

    @GET
    public Response index() {
        return Response.ok("{descricao: \"teste\"}").build();
    }

    @GET
    @Path("/{id}")
    @Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
    public Response findById(@PathParam(value = "id") Long id) {

        val agenda = agendaBean.findById(id);

        System.err.println(agenda);

        return Response.status(OK).entity("{id: \"" + 1 + "\"}")
                .type(APPLICATION_JSON)
                .build();
    }
}
