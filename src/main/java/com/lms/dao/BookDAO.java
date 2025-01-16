package com.lms.dao;

import com.lms.model.Book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookDAO {
    private String url = "jdbc:mysql://localhost:3306/librarymanagementsystem";
    private String username = "root";
    private String password = "admin_1";
    
    private static final String insertQuery = "insert into books(title, author, quantity) values(?,?,?)";
    
    //add new book
    public void insertBook(Book book) throws SQLException {
        try(Connection conn = DriverManager.getConnection(url, username, password);
                PreparedStatement ps = conn.prepareStatement(insertQuery)) {
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setInt(3, book.getQuantity());
            
            ps.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}