package br.agrotoxico.resource;

import br.agrotoxico.dto.FabricanteDTO;
import br.agrotoxico.dto.FabricanteResponseDTO;
import br.agrotoxico.service.FabricanteService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import java.util.List;

import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

/**
 * @author Marcos Ribeiro 
 */
@Path("fabricante")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FabricanteResource {

    @Inject
    FabricanteService service;

    @GET
    public Response findAll() {
        List<FabricanteResponseDTO> result = service.findAll();
        return Response.ok(result).build();
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
    
    @GET
    @Path("/cnpj/{cnpj}")
    public Response findByCnpj(@PathParam("cnpj") String cnpj) {
        FabricanteResponseDTO fabricante = service.findByCnpj(cnpj);
        return Response.ok(fabricante).build();
    }

    @POST
    public Response create(@Valid FabricanteDTO dto) {
        FabricanteResponseDTO created = service.create(dto);
        return Response.created(
                UriBuilder.fromResource(FabricanteResource.class)
                         .path(String.valueOf(created.id()))
                         .build())
                .entity(created)
                .build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, @Valid FabricanteDTO dto) {
        FabricanteResponseDTO updated = service.update(id, dto);
        return Response.ok(updated).build();
    }

    @DELETE
    @Path("/{id}")
    @APIResponse(responseCode = "204", description = "Agrotóxico excluído com sucesso")
    @APIResponse(responseCode = "404", description = "Agrotóxico não encontrado")
    public Response delete(@PathParam("id") Long id) {
        service.delete(id);
        return Response.noContent().build();
    }
}
