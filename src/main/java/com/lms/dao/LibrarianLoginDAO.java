
package com.lms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LibrarianLoginDAO {
    String sql = "select * from librarians where email=? and password=?";
    private final String dbUrl = "jdbc:mysql://localhost:3306/librarymanagementsystem";
    private final String dbUsername = "root";
    private final String dbPassword = "admin_1";
    
    public boolean check(String email, String password) {                     
        try {
            //register jdbc driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            try ( 
                    //jdbc connection
                    Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword)) {
                    PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, email);
                ps.setString(2, password);
                
                ResultSet rs = ps.executeQuery();
                if(rs.next()) {
                    return true;
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return false;
    }
}
