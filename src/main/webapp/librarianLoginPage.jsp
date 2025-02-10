
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        
        <div style="text-align:center;">
            <h1>Library Management System</h1>
            <h2>Librarian Login</h2>
            <form action="LibrarianLoginServlet" method="post">
                <label><b>Email:</b></label>
                <input type="email" name="email" required></br></br>
                <label><b>Password:</b></label>
                <input type="password" name="password" required></br></br></br>
                <button type="submit"><b>Login</b></button></br></br></br>
                <a href="index.html">Back</a>
            </form>
        </div>
    </body>
</html>
