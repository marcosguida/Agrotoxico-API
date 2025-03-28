package br.agrotoxico.resource;

import br.agrotoxico.dto.AgrotoxicoDTO;
import br.agrotoxico.dto.AgrotoxicoResponseDTO;
import br.agrotoxico.service.AgrotoxicoService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/api/agrotoxico")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AgrotoxicoResource {

    @Inject
    AgrotoxicoService service;

    @GET
    public Response findAll() {
        List<AgrotoxicoResponseDTO> agrotoxicos = service.findAll();
        return Response.ok(agrotoxicos).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        AgrotoxicoResponseDTO agrotoxico = service.findById(id);
        return Response.ok(agrotoxico).build();
    }

    @GET
    @Path("/nome/{nomeComercial}")
    public Response findByNomeComercial(@PathParam("nomeComercial") String nomeComercial) {
        AgrotoxicoResponseDTO agrotoxicos = service.findByNomeComercial(nomeComercial);
        return Response.ok(agrotoxicos).build();
    }

    @GET
    @Path("/formulacao/{tipoFormulacao}")
    public Response findByTipoFormulacao(@PathParam("tipoFormulacao") String tipoFormulacao) {
        List<AgrotoxicoResponseDTO> agrotoxicos = service.findByTipoFormulacao(tipoFormulacao);
        return Response.ok(agrotoxicos).build();
    }

    @POST
    public Response create(@Valid AgrotoxicoDTO dto) {
        AgrotoxicoResponseDTO agrotoxico = service.create(dto);
        return Response.created(URI.create("/api/agrotoxico/" + agrotoxico.id())).entity(agrotoxico).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, @Valid AgrotoxicoDTO dto) {
        AgrotoxicoResponseDTO agrotoxico = service.update(id, dto);
        return Response.ok(agrotoxico).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        service.delete(id);
        return Response.noContent().build();
    }
}
