package br.agrotoxico.resource;

import br.agrotoxico.dto.EstoqueDTO;
import br.agrotoxico.dto.EstoqueResponseDTO;
import br.agrotoxico.service.EstoqueService;
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

@Path("estoque")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EstoqueResource {

    @Inject
    EstoqueService service;

    @GET
    public Response findAll() {
        List<EstoqueResponseDTO> result = service.findAll();
        return Response.ok(result).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        EstoqueResponseDTO estoque = service.findById(id);
        return Response.ok(estoque).build();
    }

    @GET
    @Path("/lote/{lote}")
    public Response findByLote(@PathParam("lote") String lote) {
        List<EstoqueResponseDTO> estoques = service.findByLote(lote);
        return Response.ok(estoques).build();
    }
    
    @GET
    @Path("/agrotoxico/{agrotoxicoId}")
    public Response findByAgrotoxico(@PathParam("agrotoxicoId") Long agrotoxicoId) {
        List<EstoqueResponseDTO> estoques = service.findByAgrotoxico(agrotoxicoId);
        return Response.ok(estoques).build();
    }
    
    @GET
    @Path("/fornecedor/{fornecedorId}")
    public Response findByFornecedor(@PathParam("fornecedorId") Long fornecedorId) {
        List<EstoqueResponseDTO> estoques = service.findByFornecedor(fornecedorId);
        return Response.ok(estoques).build();
    }
    
    @GET
    @Path("/validade/{data}")
    public Response findByDataValidade(@PathParam("data") String data) {
        List<EstoqueResponseDTO> estoques = service.findByDataValidade(data);
        return Response.ok(estoques).build();
    }

    @POST
    public Response create(@Valid EstoqueDTO dto) {
        EstoqueResponseDTO created = service.create(dto);
        return Response.created(
                UriBuilder.fromResource(EstoqueResource.class)
                         .path(String.valueOf(created.id()))
                         .build())
                .entity(created)
                .build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, @Valid EstoqueDTO dto) {
        EstoqueResponseDTO updated = service.update(id, dto);
        return Response.ok(updated).build();
    }

    @DELETE
    @Path("/{id}")
    @APIResponse(responseCode = "204", description = "Estoque excluído com sucesso")
    @APIResponse(responseCode = "404", description = "Estoque não encontrado")
    public Response delete(@PathParam("id") Long id) {
        service.delete(id);
        return Response.noContent().build();
    }
    
    @PUT
    @Path("/{id}/quantidade/{quantidade}")
    public Response atualizarQuantidade(@PathParam("id") Long id, @PathParam("quantidade") Integer quantidade) {
        EstoqueResponseDTO updated = service.atualizarQuantidade(id, quantidade);
        return Response.ok(updated).build();
    }
    
    @PUT
    @Path("/{id}/preco-venda/{precoVenda}")
    public Response atualizarPrecoVenda(@PathParam("id") Long id, @PathParam("precoVenda") Double precoVenda) {
        EstoqueResponseDTO updated = service.atualizarPrecoVenda(id, precoVenda);
        return Response.ok(updated).build();
    }
}
