
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Librarian</title>
    </head>
    <body>
        <h1>Edit Librarian Details</h1>
        <form action="AdminServlet?action=update" method="post">
            <label><b>Librarian ID:</b></label>
            <input type="int" name="id" value="${librarian.id}"></br></br>
            <label><b>New Name:</b></label>
            <input type="text" name="name" value="${librarian.name}" required></br></br>
            <label><b>New Email:</b></label>
            <input type="email" name="email" value="${librarian.email}" required></br></br>
            <label><b>New Phone:</b></label>
            <input type="text" name="phone" value="${librarian.phone}" required></br></br></br>
            <button type="submit"><b>Update Librarian</b></button></br></br>
            <a href="AdminServlet"><b>Cancel</b></a>            
        </form>
    </body>
</html>
