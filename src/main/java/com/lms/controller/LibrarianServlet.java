package com.lms.controller;

import com.lms.dao.BookDAO;
import com.lms.model.Book;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "LibrarianServlet", urlPatterns = {"/LibrarianServlet"})
public class LibrarianServlet extends HttpServlet {
    private BookDAO bookDAO;
    
    @Override
    public void init() {
        bookDAO = new BookDAO();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action==null) action="listBooks";
        
        try {
            switch(action) {
                case "new":
                    newBook(request, response);
                    break;
                case "edit":
                    editBook(request, response);
                    break;
                case "delete":
                    deleteBook(request, response);
                    break;
                case "issue":
                    issueBookForm(request, response);
                    break;
                case "return":
                    returnBook(request, response);
                    break;
                default:
                    listBooks(request, response);
                    break;
            }
        } catch(SQLException e) {
            throw new ServletException(e);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action= request.getParameter("action");
        
        try{
            switch(action) {
                case "insert":
                    insertBook(request, response);
                    break;
                case "update":
                    updateBook(request, response);
                    break;
                case "issue":
                    issueBook(request, response);
                    break;
                case "logout":
                    logoutLibrarian(request, response);
                    break;
                default:
                    listBooks(request, response);
                    break;
            }
        } catch(SQLException e) {
            throw new ServletException(e);
        }
    }
    
    //display books
    private void listBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Book> books = bookDAO.getAllBooks();
        request.setAttribute("books", books);
        request.getRequestDispatcher("viewBooks.jsp").forward(request, response);
    }
    
    //new book form
    private void newBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("addBook.jsp").forward(request, response);
    }
    
    //edit a book form
    private void editBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        Book book = bookDAO.getBookById(id);
        request.setAttribute("book", book);
        request.getRequestDispatcher("editBook.jsp").forward(request, response);
    }
    
    //insert new book
    private void insertBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        
        Book book = new Book(title, author, quantity);
        bookDAO.insertBook(book);
        response.sendRedirect("LibrarianServlet");
    }
    
    //update book details
    private void updateBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        
        Book book = new Book(id, title, author, quantity);
        bookDAO.updateBook(book);
        response.sendRedirect("LibrarianServlet");        
    }
    
    //delete a book from the database
    private void deleteBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id").trim());
        bookDAO.deleteBook(id);
        response.sendRedirect("LibrarianServlet");
    }
    
    //issue book form
    private void issueBookForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("issueBook.jsp").forward(request, response);
    }
    
    //issue a book to a user
    private void issueBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String bookIdParam = request.getParameter("bookId");
        if(bookIdParam == null || bookIdParam.isEmpty()) {
            response.getWriter().println("<h3>Error: Book ID is required.</h3>");        
        }
        
        int bookId = Integer.parseInt(bookIdParam);
        int librarianId = Integer.parseInt(request.getParameter("librarianId"));
        
        boolean success = bookDAO.issueBook(bookId, librarianId);
        if(success) {
            response.sendRedirect("LibrarianServlet");
        } else {
            response.getWriter().println("<h3>Error: Book cannot be issued.</h3>");
        }
    }
    
    //return an issued book
    private void returnBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int bookId = Integer.parseInt(request.getParameter("id"));
        boolean success = bookDAO.returnBook(bookId);
        if(success) {
            response.sendRedirect("LibrarianServlet");
        } else {
            response.getWriter().println("<h3>Error: Book cannot be returned.</h3>");
        }
    }
    
    //logout librarian
    private void logoutLibrarian(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        if(session != null) {
            session.invalidate();
        }
        response.sendRedirect("librarianLoginPage.jsp");
    }
}
