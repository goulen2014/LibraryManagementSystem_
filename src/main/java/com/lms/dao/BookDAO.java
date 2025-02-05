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
    private static final String selectAllBooks = "select * from books";
    private static final String selectBookById = "select * from books where id=?";
    private static final String updateBook = "update books set title=?, author=?, quantity=? where id=?";
    private static final String deleteBook = "delete from books where id=?";
    private static final String issueBook = "insert into issued_books (book_id, librarian_id, issue_date, return_date) values (?,?, now(), null);";
    private static final String returnBook = "update issued_books set return_date=now() where book_id=? and return_date is null;";
    
    //add new book
    public void insertBook(Book book) throws SQLException {
        try (Connection conn = DriverManager.getConnection(url, username, password);
                PreparedStatement ps = conn.prepareStatement(insertQuery)) {
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setInt(3, book.getQuantity());
            
            ps.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
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
    
    
    //retrieve book by Id
    public Book getBookById(int id) throws SQLException {
        Book book = null;
        try(Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement ps = connection.prepareStatement(selectBookById)) {
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                String title = rs.getString("title");
                String author = rs.getString("author");
                int quantity = rs.getInt("quantity");
                
                book = new Book(title, author, quantity);
                book.setId(id);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return book;
    }
    //update book details
    public boolean updateBook(Book book) throws SQLException {
        boolean rowUpdated;
        try (Connection conn = DriverManager.getConnection(url, username, password);
                PreparedStatement ps = conn.prepareStatement(updateBook)) {
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setInt(3, book.getQuantity());
            ps.setInt(4, book.getId());
            
            rowUpdated = ps.executeUpdate() > 0;
        } 
        return rowUpdated;
    }
    
    //delete book
    public boolean deleteBook(int id) throws SQLException {
        boolean rowDeleted;
        try(Connection con = DriverManager.getConnection(url, username, password);
                PreparedStatement ps = con.prepareStatement(deleteBook)) {
            ps.setInt(1, id);
            
            rowDeleted = ps.executeUpdate() > 0;
        } 
        return rowDeleted;
    }
    
    //issue a book
    public boolean issueBook(int bookId, int librarianId) throws SQLException {
        boolean bookIssued;
        try(Connection con = DriverManager.getConnection(url, username, password);
                PreparedStatement ps = con.prepareStatement(issueBook)) {
            ps.setInt(1, bookId);
            ps.setInt(2, librarianId);
            bookIssued = ps.executeUpdate() > 0;            
        }
        return bookIssued;
    }
    
    //return a book
    public boolean returnBook(int bookId) throws SQLException {
        boolean bookReturned;
        try(Connection con = DriverManager.getConnection(url, username, password);
                PreparedStatement ps = con.prepareStatement(returnBook)) {
            ps.setInt(1, bookId);
            
            bookReturned = ps.executeUpdate() > 0;
        }
        return bookReturned;
    }
}