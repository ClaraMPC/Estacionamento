/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Motorista;
import model.bean.Vaga;

/**
 *
 * @author 40429374895
 */
public class MotoristaDAO {
    
     public void create(Motorista m){
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            
            try {
                
                stmt = con.prepareStatement("INSERT INTO motorista( nome, genero, RG, CPF, celular, email, senha) VALUES (?,?,?,?,?,?,?)");
                stmt.setString(1, m.getNomeCompleto());
                stmt.setString(2, m.getGenero());
                stmt.setInt(3, m.getRG());
                stmt.setInt(4, m.getCPF());
                stmt.setInt(5, m.getCelular());
                stmt.setString(6, m.getEmail());
                stmt.setString(7, m.getSenha());  
                
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Motorista salvo com sucesso!");
              
            }catch (SQLException e){
                JOptionPane.showMessageDialog(null,"Erro ao salvar: " + e);
                
                
            }finally{
                ConnectionFactory.closeConnection(con, stmt);
            }
        
        
        
        
    }
      public List<Motorista> read(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Motorista> motoristas = new ArrayList<>();
        try{
            
            stmt = con.prepareStatement("SELECT * FROM motorista;");
            rs = stmt.executeQuery();
            while(rs.next()){
                Motorista m = new Motorista ();
            m.setIdMotorista(rs.getInt("idMotorista"));
            m.setNomeCompleto(rs.getString("nome"));
            m.setRG(rs.getInt("RG"));
            m.setCPF(rs.getInt("CPF"));
            m.setCelular(rs.getInt("Celular"));
            m.setEmail(rs.getString("Email"));
            m.setSenha(rs.getString("Senha"));
            m.setGenero(rs.getString("genero"));
            motoristas.add(m);
            }
     
        
    }catch (SQLException e){
    throw new RuntimeException("Erro ao buscar os dados: ", e);
}finally{
    ConnectionFactory.closeConnection(con, stmt, rs);
    
}
    return motoristas;
   }
      
public void delete(Motorista m){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        
        try{
            stmt = con.prepareStatement("Delete from MOTORISTA WHERE idMotorista=?");
            stmt.setInt(1,m.getIdMotorista());
            stmt.executeUpdate();
            
            
            JOptionPane.showMessageDialog(null, "Motorista excluída com sucesso!");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + e);
        
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

}



