package br.agrotoxico.resource;

import br.agrotoxico.dto.FornecedorDTO;
import br.agrotoxico.dto.FornecedorResponseDTO;
import br.agrotoxico.service.FornecedorService;
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

@Path("fornecedor")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FornecedorResource {

    @Inject
    FornecedorService service;

    @GET
    public Response findAll() {
        List<FornecedorResponseDTO> result = service.findAll();
        return Response.ok(result).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        FornecedorResponseDTO fornecedor = service.findById(id);
        return Response.ok(fornecedor).build();
    }

    @GET
    @Path("/nome/{nome}")
    public Response findByNome(@PathParam("nome") String nome) {
        List<FornecedorResponseDTO> fornecedores = service.findByNome(nome);
        return Response.ok(fornecedores).build();
    }
    
    @GET
    @Path("/cnpj/{cnpj}")
    public Response findByCnpj(@PathParam("cnpj") String cnpj) {
        FornecedorResponseDTO fornecedor = service.findByCnpj(cnpj);
        return Response.ok(fornecedor).build();
    }

    @POST
    public Response create(@Valid FornecedorDTO dto) {
        FornecedorResponseDTO created = service.create(dto);
        return Response.created(
                UriBuilder.fromResource(FornecedorResource.class)
                         .path(String.valueOf(created.id()))
                         .build())
                .entity(created)
                .build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, @Valid FornecedorDTO dto) {
        FornecedorResponseDTO updated = service.update(id, dto);
        return Response.ok(updated).build();
    }

    @DELETE
    @Path("/{id}")
    @APIResponse(responseCode = "204", description = "Fornecedor excluído com sucesso")
    @APIResponse(responseCode = "404", description = "Fornecedor não encontrado")
    @APIResponse(responseCode = "400", description = "Não é possível excluir fornecedor com estoques associados")
    public Response delete(@PathParam("id") Long id) {
        service.delete(id);
        return Response.noContent().build();
    }
}
