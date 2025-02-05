
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.lms.model.Book" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Book</title>
    </head>
    <body>
        <h1>Edit Book Details</h1>
        <%
            Book book = (Book) request.getAttribute("book");
        %>
        
        <form action="LibrarianServlet?action=update" method="post">
            <input type="hidden" name="id" value="<%= book.getId() %>">
            
            <label>Title:</label>
            <input type="text" name="title" value="<%= book.getTitle() %>">
            
            <label>Author:</label>
            <input type="text" name="author" value="<%= book.getAuthor() %>">
            
            <label>Quantity:</label>
            <input type="number" name="quantity" value="<%= book.getQuantity() %>">
            
            <input type="submit" value="Update Book">
        </form>
            <a href="LibrarianServlet">Back to Book List</a>
    </body>
</html>
