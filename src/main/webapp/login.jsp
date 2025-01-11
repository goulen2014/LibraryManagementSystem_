
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
            <form action="LoginServlet" method="post">
                <label><b>Username:</b></label>
                <input type="text" name="username" required></br></br>
                <label><b>Password:</b></label>
                <input type="password" name="password" required></br></br></br>
                <button type="submit"><b>Login</b></button>
            </form>
        </div>
    </body>
</html>
