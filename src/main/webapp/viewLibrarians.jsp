<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.lms.model.Librarian" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Librarians</title>
    <style>
        table {
            width: 80%;
            border-collapse: collapse;
            margin: 20px auto;
        }

        th, td {
            padding: 10px;
            text-align: left;
            border: 1px solid #ddd;
        }

        th {
            background-color: #f4f4f4;
        }

        h1 {
            text-align: center;
            margin-top: 20px;
        }

        a {
            display: inline-block;
            margin: 10px auto;
            text-align: center;
            text-decoration: none;
            color: white;
            background-color: #007BFF;
            padding: 8px 12px;
            border-radius: 5px;
        }

        a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <h1>List of Librarians</h1>

    <a href="AddLibrarian">Add New Librarian</a>

    <table>
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
                    <a href="EditLibrarian?id=<%= librarian.getId() %>">Edit</a>
                    <a href="DeleteLibrarian?id=<%= librarian.getId() %>" onclick="return confirm('Are you sure you want to delete this librarian?')">Delete</a>
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
    </table>
</body>
</html>
