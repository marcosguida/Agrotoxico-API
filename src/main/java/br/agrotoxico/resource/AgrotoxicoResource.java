package br.agrotoxico.resource;

import br.agrotoxico.dto.AgrotoxicoDTO;
import br.agrotoxico.dto.AgrotoxicoResponseDTO;
import br.agrotoxico.service.AgrotoxicoService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import java.util.List;

/**
 * @author Marcos Ribeiro 
 */

@Path("agrotoxico")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AgrotoxicoResource {

    @Inject
    AgrotoxicoService service;

    @GET
    public Response findAll() {
        List<AgrotoxicoResponseDTO> result = service.findAll();
        return Response.ok(result).build();
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
        AgrotoxicoResponseDTO agrotoxico = service.findByNomeComercial(nomeComercial);
        return Response.ok(agrotoxico).build();
    }

    @GET
    @Path("/formulacao/{tipoFormulacao}")
    public Response findByTipoFormulacao(@PathParam("tipoFormulacao") String tipoFormulacao) {
        List<AgrotoxicoResponseDTO> agrotoxicos = service.findByTipoFormulacao(tipoFormulacao);
        return Response.ok(agrotoxicos).build();
    }
    
    @GET
    @Path("/fabricante/{fabricanteId}")
    public Response findByFabricante(@PathParam("fabricanteId") Long fabricanteId) {
        List<AgrotoxicoResponseDTO> agrotoxicos = service.findByFabricante(fabricanteId);
        return Response.ok(agrotoxicos).build();
    }

    @POST
    public Response create(@Valid AgrotoxicoDTO dto) {
        AgrotoxicoResponseDTO created = service.create(dto);
        return Response.created(
                UriBuilder.fromResource(AgrotoxicoResource.class)
                         .path(String.valueOf(created.id()))
                         .build())
                .entity(created)
                .build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, @Valid AgrotoxicoDTO dto) {
        AgrotoxicoResponseDTO updated = service.update(id, dto);
        return Response.ok(updated).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        service.delete(id);
        return Response.noContent().build();
    }
}
