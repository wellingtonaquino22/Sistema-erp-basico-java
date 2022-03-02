/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.dao;

import erp.jdbc.ConnectionFactory;
import erp.objects.Clientes;
import erp.objects.Vendas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author alex
 */
public class VendasDAO {
    
    private Connection con;
    
    public VendasDAO(){
        this.con = new ConnectionFactory().getConnection();
    }
    
    public void cadastrarVenda(Vendas obj){
        try {
            String sql = "insert into vendas (cliente_id, data_venda, total_venda,observacoes) values (?,?,?,?)";
            
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, obj.getCliente().getId());
            stm.setString(2, obj.getData_venda());
            stm.setDouble(3, obj.getTotal_venda());
            stm.setString(4, obj.getObs());
                        
            stm.execute();
            stm.close();
            
   
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
    }
    
    public int retornaUltimaVenda() {
        try {
            int idvenda = 0;

            String sql = "select max(id) id from vendas";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Vendas p = new Vendas();

                p.setId(rs.getInt("id"));
                idvenda = p.getId();
            }

            return idvenda;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    
    public double retornaTotalVendaPorData(LocalDate data_venda) {
        try {

            double totalvenda = 0;

            String sql = "select sum(total_venda) as total from vendas where data_venda = ?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, data_venda.toString());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                totalvenda = rs.getDouble("total");
            }

            return totalvenda;
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    
}
