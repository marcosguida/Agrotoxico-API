package br.agrotoxico.model;

import jakarta.persistence.*;
import java.time.LocalDate;

/**
 * @author Marcos Ribeiro 
 */

@Entity
@Table(name = "estoque")
public class Estoque extends DefaultEntity {

    @Column(nullable = false)
    private Integer quantidade;
    
    @Column(name = "data_entrada", nullable = false)
    private LocalDate dataEntrada;
    
    @Column(name = "data_validade")
    private LocalDate dataValidade;
    
    @Column(length = 50)
    private String lote;
    
    @Column(name = "preco_compra", nullable = false)
    private Double precoCompra;
    
    @Column(name = "preco_venda", nullable = false)
    private Double precoVenda;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agrotoxico_id", nullable = false)
    private Agrotoxico agrotoxico;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fornecedor_id", nullable = false)
    private Fornecedor fornecedor;

    public Estoque() {
    }
    
    public Estoque(Integer quantidade, LocalDate dataEntrada, Double precoCompra, Double precoVenda, 
                   Agrotoxico agrotoxico, Fornecedor fornecedor) {
        this.quantidade = quantidade;
        this.dataEntrada = dataEntrada;
        this.precoCompra = precoCompra;
        this.precoVenda = precoVenda;
        this.agrotoxico = agrotoxico;
        this.fornecedor = fornecedor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public Double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(Double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public Double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(Double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public Agrotoxico getAgrotoxico() {
        return agrotoxico;
    }

    public void setAgrotoxico(Agrotoxico agrotoxico) {
        this.agrotoxico = agrotoxico;
    }
    
    public Fornecedor getFornecedor() {
        return fornecedor;
    }
    
    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
}
