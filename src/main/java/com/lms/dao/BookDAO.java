package com.lms.dao;

import com.lms.model.Book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    
    private static final String selectAllBooks = "select * from books";
    
    //retrieve all books
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement ps = connection.prepareStatement(selectAllBooks)) {
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                int quantity = rs.getInt("quantity");
                
                Book book = new Book(title, author, quantity);
                book.setId(id);
                
                books.add(book);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
}