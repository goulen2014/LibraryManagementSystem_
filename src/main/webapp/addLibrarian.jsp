
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Librarian</title>
    </head>
    <body>
        <h1>Add New Librarian</h1>
        <form action="AdminServlet?action=insert" method="post">
            <label><b>Name:</b></label>
            <input type="text" name="name" required></br></br>
            <label><b>Email:</b></label>
            <input type="email" name="email" required></br></br>
            <label><b>Phone:</b></label>
            <input type="text" name="phone" required></br></br>
            <input type="submit" value="Add"></br></br></br>
            <a href="addLibrarian.jsp"><b>Cancel</b></a>         
            <a href="adminDashboard.jsp"><b>Back</b></a>         
        </form>
    </body>
</html>
