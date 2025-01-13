package com.lms.dao;

import com.lms.model.Librarian;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibrarianDAO {
    private final String url = "jdbc:mysql://localhost:3306/librarymanagementsystem";
    private final String user = "root";
    private final String password = "admin_1";
    
    private static final String insertLibrarian = "insert into librarians(name, email, phone) values(?,?,?)";
    private static final String viewLibrarian = "select id, name, email, phone from librarians where id=?";
    private static final String viewAllLibrarians = "select * from librarians";
    private static final String updateLibrarian = "update librarians set name=?, email=?, phone=? where id=?";
    private static final String deleteLibrarian = "delete from librarians where id=?"; 
 
    static {
        try {
            // Optional: Explicitly register the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("MySQL Driver not found", e);
        }
    }
    
    protected Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch(Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to establish a database connection", e);
        }
        return connection;
    }
    
    //add librarian
    public void insertLibrarian(Librarian bean) throws SQLException {
        try (Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(insertLibrarian)) {
            ps.setString(1, bean.getName());
            ps.setString(2, bean.getEmail());
            ps.setString(3, bean.getPhone());
            ps.executeUpdate();            
        } catch(SQLException e) {
            e.printStackTrace();
        }        
    }
    //view a librarian
    public Librarian getLibrarianById(int id) throws SQLException {
        Librarian librarian = null;
        try (Connection connection = getConnection();
                PreparedStatement ps = connection.prepareStatement(viewLibrarian)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                librarian = new Librarian(id, name, email, phone);
            }            
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return librarian;
    }
    //view all librarians
    public List<Librarian> getAllLibrarians() throws SQLException {
        List<Librarian> librarians = new ArrayList<>();
        try (Connection connection = getConnection();
                PreparedStatement ps = connection.prepareStatement(viewAllLibrarians)) {
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                
                librarians.add(new Librarian(id, name, email, phone));
            }            
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return librarians;
    }
    //update librarian
    public void updateLibrarian(Librarian librarian) throws SQLException {
        try(Connection connection = getConnection();
                PreparedStatement ps = connection.prepareStatement(updateLibrarian)) {
            ps.setString(1, librarian.getName());
            ps.setString(2, librarian.getEmail());
            ps.setString(3, librarian.getPhone());
            ps.setInt(4, librarian.getId());
            
            ps.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    //delete librarian
    public void deleteLibrarian(int id) throws SQLException {
        try(Connection connection = getConnection();
                PreparedStatement ps = connection.prepareStatement(deleteLibrarian)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
