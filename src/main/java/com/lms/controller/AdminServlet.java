package com.lms.controller;

import com.lms.dao.LibrarianDAO;
import com.lms.model.Librarian;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AdminServlet", urlPatterns = {"/AdminServlet"})
public class AdminServlet extends HttpServlet {
    private LibrarianDAO librarianDAO;
    
    @Override
    public void init() {
        librarianDAO = new LibrarianDAO();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String action = request.getParameter("action");
        if(action == null) action = "list";
        
        try {
            switch(action) {
                case "new":
                    newLibrarianForm(request, response);
                    break;
                case "edit":
                    editLibrarianForm(request, response);
                    break;
                case "delete":
                    deleteLibrarian(request, response);
                    break;
                case "logout":
                    logoutAdmin(request, response);
                    break;
                default:
                    listLibrarians(request, response);
                    break;
            }
        } catch(Exception e) {
                    throw new ServletException(e);
        }
        System.out.println("Admin servlet invoked");
    }        
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String action = request.getParameter("action");
        
        try {
            switch(action) {
                case "insert":
                    insertLibrarian(request, response);
                    break;
                case "update":
                    updateLibrarian(request, response);
                    break;
                default:
                    listLibrarians(request, response);
                    break;                
            }
        } catch(Exception e) {
            throw new ServletException(e);
        }
    }
        
    private void listLibrarians(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Librarian> librarians = librarianDAO.getAllLibrarians();
        request.setAttribute("librarians", librarians);
        request.getRequestDispatcher("viewLibrarians.jsp").forward(request, response);
    }
    
    private void newLibrarianForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("addLibrarian.jsp").forward(request, response);
    }
    
    private void editLibrarianForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        Librarian librarian = librarianDAO.getLibrarianById(id);
        request.setAttribute("librarian", librarian);
        request.getRequestDispatcher("editLibrarian.jsp").forward(request, response);
    }
    
    private void insertLibrarian(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        
        Librarian librarian = new Librarian(name, email, phone);
        librarianDAO.insertLibrarian(librarian);
        response.sendRedirect("AdminServlet");
    }
    
    private void updateLibrarian(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        
        Librarian librarian = new Librarian(id, name, email, phone);
        librarianDAO.updateLibrarian(librarian);
        response.sendRedirect("AdminServlet");
    }
    
    private void deleteLibrarian(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        
        librarianDAO.deleteLibrarian(id);
        response.sendRedirect("AdminServlet");
    }
    
    private void logoutAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        HttpSession session = request.getSession();        
        if(session != null) {  
            session.removeAttribute("username");
            session.invalidate();            
        }
        response.sendRedirect("login.jsp");
    }
}