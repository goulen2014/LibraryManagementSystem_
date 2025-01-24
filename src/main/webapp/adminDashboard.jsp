
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Dashboard</title>
    </head>
    <body>
        <%
            //prevent back button after logout
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");//HTTP 1.1
            response.setHeader("Pragma", "no-cache");//HTTP 1.0
            response.setHeader("Expires", "0");//Proxies
            //redirect if username is null
            if(session.getAttribute("username")==null) {
                response.sendRedirect("login.jsp");
            }
        %>
        
        <div style="text-align:center;">
            <h1>Welcome, ${username}!</h1>
            <a href="AdminServlet?action=new"><b>Add Librarian</b></a></br></br>
            <a href="AdminServlet"><b>View Librarians</b></a></br></br>
            <a href="AdminServlet?action=edit"><b>Update Librarian</b></a></br></br>
            <a href="AdminServlet?action=logout"><b>Logout</b></a>
        </div>
    </body>
</html>
