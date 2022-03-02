/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.dao;

import java.sql.Connection;
import erp.jdbc.ConnectionFactory;
import erp.objects.Fornecedor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class FornecedorDAO {
    
    private Connection conFor;
    
    public FornecedorDAO(){
        this.conFor = new ConnectionFactory().getConnection();
    }
    
    public void adicionarFornecedor(Fornecedor obj){
        try {
            String sql = "insert into fornecedor (nome, cnpj, fone, email, ie, cep, cidade, uf, endereco) "
                    + "value (?,?,?,?,?,?,?,?,?)";
            PreparedStatement stm = conFor.prepareStatement(sql);
            stm.setString(1, obj.getNome());
            stm.setString(2, obj.getCnpj());
            stm.setString(3, obj.getFone());
            stm.setString(4, obj.getEmail());
            stm.setString(5, obj.getIe());
            stm.setString(6, obj.getCep());
            stm.setString(7, obj.getCidade());
            stm.setString(8, obj.getUf());
            stm.setString(9, obj.getEndereco());
            
            stm.execute();
            stm.close();
            
            JOptionPane.showMessageDialog(null, "Cadastrado realizado com sucesso");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error ao cadastrar:" + " " +e);
        }
    }
    
    public void updateFornecedor(Fornecedor obj){
        try {
            String sql = "update fornecedor set nome=?, cnpj=?, fone=?, email=?, ie=?,"
                    + " cep=?, cidade=?, uf=?, endereco=? where id=?";
            
            PreparedStatement stm = conFor.prepareStatement(sql);
            stm.setString(1, obj.getNome());
            stm.setString(2, obj.getCnpj());
            stm.setString(3, obj.getFone());
            stm.setString(4, obj.getEmail());
            stm.setString(5, obj.getIe());
            stm.setString(6, obj.getCep());
            stm.setString(7, obj.getCidade());
            stm.setString(8, obj.getUf());
            stm.setString(9, obj.getEndereco());
            stm.setInt(10, obj.getId());
            
            stm.execute();
            stm.close();
            
            JOptionPane.showMessageDialog(null, "Cadastrado alterado com sucesso");
                    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar cadastro:"+" "+e);
        }
    }
    
    public void deleteFornecedor(Fornecedor obj){
        try {
            String sql ="delete from fornecedor where id=?";
            
            PreparedStatement stm = conFor.prepareStatement(sql);
            stm.setInt(1,obj.getId());
            
            stm.execute();
            stm.close();
            
            JOptionPane.showMessageDialog(null, "Cadastrado excluido com sucesso");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir cadastro:"+" "+e);
        }
    }
    
    public List<Fornecedor> listarNomeFornecedorParaProd(){
        try {
            List<Fornecedor> listaForProd = new ArrayList<>();
            
            String sql = "select nome from fornecedor";
            
            PreparedStatement stm = conFor.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
                Fornecedor obj = new Fornecedor();
                
                obj.setNome(rs.getString("nome"));
                listaForProd.add(obj);
            }
            return listaForProd;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Listar nome:"+" "+e);
                return null;
        }
    }
    
    public List<Fornecedor> listarFornecedorParaProd(){
        try {
            List<Fornecedor> listaForProd = new ArrayList<>();
            
            String sql = "select id,nome from fornecedor";
            
            PreparedStatement stm = conFor.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
                Fornecedor obj = new Fornecedor();
                
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                listaForProd.add(obj);
            }
            return listaForProd;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Listar:"+" "+e);
                return null;
        }
    }
    public List<Fornecedor> listarFornecedor(){
            try {
                List<Fornecedor> lista = new ArrayList<>();
                
                String sql = "select * from fornecedor";
                
                PreparedStatement stm = conFor.prepareStatement(sql);
                ResultSet rs = stm.executeQuery();
                
                while (rs.next()){
                    Fornecedor obj = new Fornecedor();
                    
                    obj.setId(rs.getInt("id"));
                    obj.setNome(rs.getString("nome"));
                    obj.setCnpj(rs.getString("cnpj"));
                    obj.setFone(rs.getString("fone"));
                    obj.setEmail(rs.getString("email"));
                    obj.setIe(rs.getString("ie"));
                    obj.setCep(rs.getString("cep"));
                    obj.setCidade(rs.getString("cidade"));
                    obj.setUf(rs.getString("uf"));
                    obj.setEndereco(rs.getString("endereco"));
                    
                    lista.add(obj);
                }
                return lista;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao Listar:"+" "+e);
                return null;
            }
}
        public List<Fornecedor> buscarFornecedorPorNome(String nome){
        try {
            List<Fornecedor> lista = new ArrayList();
            
            String sql ="select * from fornecedor where nome like ?";
            PreparedStatement stmt = conFor.prepareStatement(sql);
            stmt.setString(1,nome);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Fornecedor obj = new Fornecedor();
                
                    obj.setId(rs.getInt("id"));
                    obj.setNome(rs.getString("nome"));
                    obj.setCnpj(rs.getString("cnpj"));
                    obj.setFone(rs.getString("fone"));
                    obj.setEmail(rs.getString("email"));
                    obj.setIe(rs.getString("ie"));
                    obj.setCep(rs.getString("cep"));
                    obj.setCidade(rs.getString("cidade"));
                    obj.setUf(rs.getString("uf"));
                    obj.setEndereco(rs.getString("endereco"));
                    
		     lista.add(obj);           
            }
            return lista;
        } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao Buscar Fornecedor:"+" "+e);
                return null;
        }
    }
}