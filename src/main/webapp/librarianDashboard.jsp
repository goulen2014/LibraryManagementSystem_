
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Librarian Dashboard</title>
    </head>
    <body>
        <%
            //prevent back button after logout
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");//HTTP 1.1
            response.setHeader("Pragma", "no-cache");//HTTP 1.0
            response.setHeader("Expires", "0");//Proxies
            //redirect if email is null
            if(session.getAttribute("email")==null) {
                response.sendRedirect("librarianLoginPage.jsp");
            }
        %>
        <div style="text-align: center;">
            <h1>Welcome, Librarian!</h1>
            <ul>
                <li><a href="LibrarianServlet?action=new"><b>Add new book</b></li></br>
                <li><a href="LibrarianServlet"><b>View all books</b></li></br>
                <li><a href="LibrarianServlet?action=viewIssuedBooks"><b>View Issued Books</b></a></li></br></br>
                <li><a href="LibrarianServlet?action=logout">Logout</a></li>
            </ul>
        </div>
    </body>
</html>
