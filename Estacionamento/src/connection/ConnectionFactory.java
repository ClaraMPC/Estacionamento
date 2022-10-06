/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



/**
 *
 * @author Malva
 */
public class ConnectionFactory {
    
    private static final String DRIVER = "com.mysql.jbdc.Driver";
    private static final String URL = "jbdc://localhost:3306/estacionamento";
    private static final String USER = "root";
    private static final String PASS = "";
    
    
    public static Connection getConnection() {
        
        try{
                Class.forName(DRIVER);
                return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e){
            
           throw new RuntimeException ("Erro na conexão: ", e);
        }
           
            
    }

    public static void closeConnection(Connection con){
        try{
            if(con != null) {
                con.close();
            }
        }catch (SQLException e){
            throw new RuntimeException("Erro ao desconectar: ", e);
        }
    }
   

    public static void closeConnection(Connection con, PreparedStatement stmt){
        try{
            if(stmt != null) {
                stmt.close();
            }
        }catch (SQLException e){
            throw new RuntimeException("Erro ao desconectar: ", e);
        }
    }
    
     public static void closeConnection(Connection con, PreparedStatement stmt,ResultSet rs){
         closeConnection(con, stmt);
        try{
            if(rs != null) {
                rs.close();
            }
        }catch (SQLException e){
            throw new RuntimeException("Erro ao desconectar: ", e);
        }
    }
}

