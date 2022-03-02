/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.objects;

/**
 *
 * @author alex
 */
public class Produtos {
    
    private int id;
    private String descricao;
    private Double preco;
    private Double lucro;
    private Double pvenda;
    private int qde_estoque;
    private Fornecedor fornecedor;

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double getLucro() {
        return lucro;
    }

    public void setLucro(Double lucro) {
        this.lucro = lucro;
    }

    public Double getPvenda() {
        return pvenda;
    }

    public void setPvenda(Double pvenda) {
        this.pvenda = pvenda;
    }

    public int getQde_estoque() {
        return qde_estoque;
    }

    public void setQde_estoque(int qde_estoque) {
        this.qde_estoque = qde_estoque;
    }
  
    
    
    
}
