
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Dashboard</title>
    </head>
    <body>
        <div style="text-align:center;">
            <h1>Welcome, Admin!</h1>
            <a href="addLibrarian.jsp"><b>Add Librarian</b></a></br></br>
            <a href="AdminServlet"><b>View Librarians</b></a></br></br>
            <a href="editLibrarian.jsp"><b>Update Librarian</b></a></br></br>
            <a href="AdminServlet?action=logout"><b>Logout</b></a>
        </div>
    </body>
</html>
