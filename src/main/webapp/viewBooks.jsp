
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="com.lms.model.Book" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Books</title>
    </head>
    <body>
        <h1>List of Books</h1>
        
        <a href="AddBook">Add New Book</a>
        
        <table>
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Title</th>
                    <th>Author</th>
                    <th>Quantity</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    List<Book> books = (List<Book>) request.getAttribute("books");
                    if(books != null && !books.isEmpty()) {
                        for(Book book: books) {
                %>
                <tr>
                    <td><%= book.getId()  %></td>
                    <td><%= book.getTitle()  %></td>
                    <td><%= book.getAuthor()  %></td>
                    <td><%= book.getQuantity()  %></td>
                </tr>
                <%
                    }
                } else {
                %>
                <tr>
                    <td style="text-align: center;">No books found.</td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </body>
</html>
