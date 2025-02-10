
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.lms.model.IssuedBooks" %>
<%@page import="java.util.List" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Issued Books</title>
    </head>
    <body>
        <div style="text-align: center";>
            <h1>Issued Books</h1>
            <table border="1" style="margin: 0px auto;">
                <tr>
                    <th>Book ID</th>                    
                    <th>Librarian ID</th>               
                    <th>Issued To</th>               
                    <th>Issue Date</th>               
                    <th>Return Date</th>               
                </tr>
                <%
                    List<IssuedBooks> books = (List<IssuedBooks>)request.getAttribute("issuedBooks");
                        if(books != null) {
                            for(IssuedBooks book : books) {                    
                %>
                        <tr>
                            <td><%=book.getBookId()%></td>
                            <td><%=book.getLibrarianId()%></td>
                            <td><%=book.getIssuedTo()%></td>
                            <td><%=book.getIssueDate()%></td>
                            <td><%=book.getReturnDate() != null? book.getReturnDate() : "Not returned." %></td>
                        </tr>
                        <%
                            }
                        } else {
                        %>
                        <tr><td colspan="5">No books issued.</td></tr>
                        <% } %>           
            </table></br></br>
            <a href="LibrarianServlet">Back to Book List</a> |
            <a href="librarianDashboard.jsp">Back to Dashboard</a>
        </div>
    </body>
</html>
