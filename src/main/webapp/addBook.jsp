
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Book</title>
    </head>
    <body>
        <h1>Add Book</h1>
        
        <form action="AddBook" method="post">
            <label for="title">Title:</label>
            <input type="text" name="title" required>
            <label for="author">Author</label>
            <input type="text" name="author" required>
            <label for="quantity">Quantity:</label>
            <input type="number" name="quantity" required>
            <button type="submit">Add Book</button>
        </form>
    </body>
</html>
