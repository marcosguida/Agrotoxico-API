package br.agrotoxico.resource;

import br.agrotoxico.dto.FabricanteDTO;
import br.agrotoxico.dto.FabricanteResponseDTO;
import br.agrotoxico.service.FabricanteService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/api/fabricante")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FabricanteResource {

    @Inject
    FabricanteService service;

    @GET
    public Response findAll() {
        List<FabricanteResponseDTO> fabricantes = service.findAll();
        return Response.ok(fabricantes).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        FabricanteResponseDTO fabricante = service.findById(id);
        return Response.ok(fabricante).build();
    }

    @GET
    @Path("/nome/{nome}")
    public Response findByNome(@PathParam("nome") String nome) {
        List<FabricanteResponseDTO> fabricantes = service.findByNome(nome);
        return Response.ok(fabricantes).build();
    }

    @POST
    public Response create(@Valid FabricanteDTO dto) {
        FabricanteResponseDTO fabricante = service.create(dto);
        return Response.created(URI.create("/api/fabricante/" + fabricante.id())).entity(fabricante).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, @Valid FabricanteDTO dto) {
        FabricanteResponseDTO fabricante = service.update(id, dto);
        return Response.ok(fabricante).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        service.delete(id);
        return Response.noContent().build();
    }
}
