/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

//import com.mysql.jdbc.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.util.Scanner;


/**
 *
 * @author vikramsingh
 */
public class Prepare {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT id,`key`,`value` FROM configuration WHERE `id` = ?";
            int id = 3;
            conn = DriverManager.getConnection("jdbc:mysql://localhost/app_backend", "root", "");
            //stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); 
            stmt.setInt(1,3);
            rs = stmt.executeQuery();
            //rs = stmt.executeQuery("SELECT id,`key`,`value` FROM configuration where id=?");
            
            rs.last();
            System.out.println(rs.getString("key"));
            
            
            
        } catch (SQLException ex) {
            //Logger.getLogger(Jdbc.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error Message: " + ex.getMessage());
            System.out.println("Error Code: " + ex.getErrorCode());
            System.out.println("Error Message: " + ex.getSQLState());
            
        } finally {
            if(rs != null ) {
                rs.close();
            }
            if(stmt != null ) {
                stmt.close();
            }            

            if(conn != null ) {
                conn.close();
            }
            
        }
        
    }
    
}
