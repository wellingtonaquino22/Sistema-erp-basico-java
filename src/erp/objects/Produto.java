/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.objects;

/**
 *
 * @author 
 */
public class Produto {
    
    private int id;
    private String nome;
    private String unidade;
    private int precoDeCompra;
    private double precoDeVenda;
    private int fornecedor;
    private String estoque;

 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getUnidade() {
        return unidade;
    }


    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }


    public int getPrecoDeCompra() {
        return precoDeCompra;
    }


    public void setPrecoDeCompra(int precoDeCompra) {
        this.precoDeCompra = precoDeCompra;
    }


    public double getPrecoDeVenda() {
        return precoDeVenda;
    }


    public void setPrecoDeVenda(double precoDeVenda) {
        this.precoDeVenda = precoDeVenda;
    }


    public int getFornecedor() {
        return fornecedor;
    }


    public void setFornecedor(int fornecedor) {
        this.fornecedor = fornecedor;
    }


    public String getEstoque() {
        return estoque;
    }


    public void setEstoque(String estoque) {
        this.estoque = estoque;
    }
    
}
