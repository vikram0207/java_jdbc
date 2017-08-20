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


/**
 *
 * @author vikramsingh
 */
public class Jdbc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/app_backend", "root", "");
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            rs = stmt.executeQuery("SELECT id,`key`,`value` FROM configuration");
            
            while(rs.next()) {
                System.out.println("Id: " + rs.getString("id"));
                System.out.println("Key: " + rs.getString("key"));
            }
            
            System.out.println(rs.absolute(3));
            System.out.println(rs.getString("key"));
            //rs.last();
            System.out.println(rs.getRow());
            
            System.out.println("Connected");
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
