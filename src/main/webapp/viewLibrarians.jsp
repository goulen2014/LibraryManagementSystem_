<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.lms.model.Librarian" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Librarians</title>    
</head>
<body>
    <div style="text-align: center";>
        <h1>List of Librarians</h1>
    
        <form action="AdminServlet" method="get">          
            <table border="1" style="margin: 0px auto;">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Phone</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        // Retrieve the list of librarians from the request attribute
                        List<Librarian> librarians = (List<Librarian>) request.getAttribute("librarians");
                        if (librarians != null && !librarians.isEmpty()) {
                            for (Librarian librarian : librarians) {
                    %>
                    <tr>
                        <td><%= librarian.getId() %></td>
                        <td><%= librarian.getName() %></td>
                        <td><%= librarian.getEmail() %></td>
                        <td><%= librarian.getPhone() %></td>
                        <td>
                            <a href="editLibrarian.jsp?id=<%= librarian.getId() %>">Edit</a> |
                            <a href="AdminServlet?id=<%= librarian.getId() %>&action=delete" onclick="return confirm('Are you sure you want to delete this librarian?')">Delete</a>
                        </td>
                    </tr>
                    <%
                            }
                        } else {
                    %>
                    <tr>
                        <td colspan="5" style="text-align: center;">No librarians found.</td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table></br></br>    
            <a href="addLibrarian.jsp"><b>Add New Librarian</b></a> |
            <a href="adminDashboard.jsp"><b>Back</b></a>    
        </form>
    </div>
    
</body>
</html>
