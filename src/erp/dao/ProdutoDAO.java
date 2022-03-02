/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.dao;

import java.sql.Connection;
import erp.jdbc.ConnectionFactory;
import erp.objects.Produto;
import erp.objects.Fornecedor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import erp.view.frmProduto;

/**
 *
 * @author 
 */
public class ProdutoDAO {
    
    public Connection conProde;
    public ProdutoDAO(){
        this.conProde = new ConnectionFactory().getConnection();
    }
   //ProdutosDAO prod = new ProdutosDAO();
    

    public void adicionarProduto(Produto obj){
        try {
            String sql = "insert into produto (nome, unidade, precoDeCompra, precoDeVenda, fornecedor, estoque)"
                    + "value(?,?,?,?,?,?)";
            PreparedStatement stm = conProde.prepareStatement(sql);
            stm.setString(1, obj.getNome());     
            stm.setString(2, obj.getUnidade());
            stm.setInt(3, obj.getPrecoDeCompra());
            stm.setDouble(4, obj.getPrecoDeVenda());
            stm.setInt(5, obj.getFornecedor());
            stm.setString(6, obj.getEstoque());
            
            stm.execute();
            stm.close();
            
            JOptionPane.showMessageDialog(null, "Cadastro de produto feito com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao efetuar cadastro de produto"+" "+e);
        }
    }
    
    public void updateProduto(Produto obj){
        try {
            String sql = "update produto set nome=?, unidade=?, precoDeCompra=?, "
                    + "precoDeVenda=?, fornecedor=?, estoque=? where id=?";
            
            PreparedStatement stm = conProde.prepareStatement(sql);
            stm.setString(1, obj.getNome());     
            stm.setString(2, obj.getUnidade());
            stm.setInt(3, obj.getPrecoDeCompra());
            stm.setDouble(4, obj.getPrecoDeVenda());
            stm.setInt(5, obj.getFornecedor());
            stm.setString(6, obj.getEstoque());
            stm.setInt(7, obj.getId());
            
            stm.execute();
            stm.close();
            
            JOptionPane.showMessageDialog(null, "Produto alterado com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar produto: "+e);
        }
    }
    
   public void deleteProduto(Produto obj){
        try {
            String sql = "delete from produto where id=?";
            
            PreparedStatement stm = conProde.prepareStatement(sql);
            stm.setInt(1, obj.getId());
            
            stm.execute();
            stm.close();
            
            JOptionPane.showMessageDialog(null, "Produto excluido com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir produto"+" "+e);
        }
    }
    
    public List<Produto> listarProduto(){
        try {
            List<Produto> lista = new ArrayList<>();
            
            String sql = "select * from produto";
            
            
            PreparedStatement stm = conProde.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            
           while (rs.next()){
               Produto obj = new Produto();
               
               obj.setId(rs.getInt("id"));
               obj.setNome(rs.getString("nome"));
               obj.setUnidade(rs.getString("unidade"));
               obj.setPrecoDeCompra(rs.getInt("precoDeCompra"));
               obj.setPrecoDeVenda(rs.getDouble("precoDeVenda"));
               obj.setFornecedor(rs.getInt("fornecedor"));
               obj.setEstoque(rs.getString("estoque"));
               
               
               lista.add(obj);
                
           }
           return lista;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar Produto: "+e);
            return null;
        }
    }
    
    public List<Produto> buscarProdutoPorNome(String nome){
        try {
            List<Produto> lista = new ArrayList();
            
            String sql ="select * from produto where nome like ?";
            PreparedStatement stmt = conProde.prepareStatement(sql);
            stmt.setString(1,nome);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Produto obj = new Produto();
                
               obj.setId(rs.getInt("id"));
               obj.setNome(rs.getString("nome"));
               obj.setUnidade(rs.getString("unidade"));
               obj.setPrecoDeCompra(rs.getInt("precoDeCompra"));
               obj.setPrecoDeVenda(rs.getDouble("precoDeVenda"));
               obj.setFornecedor(rs.getInt("fornecedor"));
               obj.setEstoque(rs.getString("estoque"));
                    
                    lista.add(obj);           
            }
            return lista;
        } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao Buscar Produto:"+" "+e);
                return null;
        }
    }
}