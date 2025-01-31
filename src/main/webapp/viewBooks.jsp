
<%@ page import="java.util.List" %>
<%@ page import="com.lms.model.Book" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
    <head>
        <title>View Books</title>
    </head>
    <body>
        <h1>Book List</h1>
        <a href="addBook.jsp">Add New Book</a> | <a href="librarianDashboard.jsp">Back to Dashboard</a>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Author</th>
                <th>Quantity</th>
                <th>Actions</th>
            </tr>
            <% 
                List<Book> books = (List<Book>) request.getAttribute("books");
                if(books != null) {
                    for(Book book : books) {
            %>
            <tr>
                <td><%= book.getId() %></td>
                <td><%= book.getTitle() %></td>
                <td><%= book.getAuthor() %></td>
                <td><%= book.getQuantity() %></td>
                <td>
                    <a href="LibrarianServlet?action=edit&id=<%= book.getId() %>">Edit</a> |
                    <a href="LibrarianServlet?action=delete&id= <%= book.getId() %>" onclick="return confirm('Are you sure?')">Delete</a> |
                    <a href="issueBook.jsp?bookId= <%= book.getId() %>">Issue</a> | 
                    <a href="LibrarianServlet?action=return&bookId=<%=book.getId() %>">Return</a>
                </td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr><td colspan="6">No books available.</td></tr>
            <% } %>
        </table>
    </body>
</html>